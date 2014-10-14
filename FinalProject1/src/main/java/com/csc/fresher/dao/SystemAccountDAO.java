package com.csc.fresher.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.csc.fresher.controller.EntityManagerFactoryUtil;
import com.csc.fresher.domain.SystemAccount;

/*@author TrinhLe
 * 
 */
@Component
public class SystemAccountDAO {

	public List<SystemAccount> getSystemAccounts() {
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		List<SystemAccount> systemaccounts = null;

		entityTransaction.begin();
		/* try { */
		TypedQuery<SystemAccount> query = entityManager.createQuery(
				"SELECT a FROM SystemAccount a", SystemAccount.class);
		systemaccounts = query.getResultList();

		entityTransaction.commit();
		/*
		 * } catch (Exception e) { entityManager.close(); }
		 */

		return systemaccounts;
	}

	/**
	 * Login systemAccount
	 * 
	 * @param username
	 * @param password
	 * @return true if username.getPassword == password
	 */
	public boolean getSystemAccount(String username, String password) {

		// Obtains entity manager object
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		// -----------Begin transaction-----------
		boolean check = false;
		try {
			entityTransaction.begin();

			TypedQuery<SystemAccount> query = entityManager
					.createQuery(
							"SELECT c FROM "
									+ SystemAccount.class.getName()
									+ " c Where c.username= :username and c.password= :password",
							SystemAccount.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			SystemAccount sys = query.getSingleResult();
			System.out.println(sys.getUsername());
			check = query.getResultList().size() > 0;
			entityTransaction.commit();
		} catch (Exception e) {
			entityManager.close(); 
		}
		// -----------End transaction-----------

		return check;
	}

	public boolean addSystemAccount(SystemAccount systemAccount) {
		// Obtains entity manager object
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		boolean result = true;
		
		entityTransaction.begin();
		
		entityManager.persist(systemAccount);
		
		entityTransaction.commit();
		
		return result;
	}
}
