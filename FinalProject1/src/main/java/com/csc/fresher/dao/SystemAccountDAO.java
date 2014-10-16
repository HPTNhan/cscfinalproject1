package com.csc.fresher.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.csc.fresher.controller.EntityManagerFactoryUtil;
import com.csc.fresher.domain.Account;
import com.csc.fresher.domain.SystemAccount;

@Component
public class SystemAccountDAO {

	public List<SystemAccount> getSystemAccounts() {
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		List<SystemAccount> systemaccounts = null;

		entityTransaction.begin();
		try {
			TypedQuery<SystemAccount> query = entityManager.createQuery(
					"SELECT a FROM SystemAccount a", SystemAccount.class);
			systemaccounts = query.getResultList();

			entityTransaction.commit();

		} catch (Exception e) {
			entityManager.close();
		}

		return systemaccounts;
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

	/**
	 * @author TrinhLe Login systemAccount
	 * 
	 * @param username
	 * @param password
	 * @return systemAccount
	 */
	public SystemAccount getSystemAccount(String username, String password) {

		// Obtains entity manager object
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		SystemAccount systemAccount = new SystemAccount();
		// -----------Begin transaction-----------
		// boolean check = false;
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
			systemAccount = query.getSingleResult();
			System.out.println(systemAccount.getUsername());
			// check = query.getResultList().size() > 0;
			entityTransaction.commit();
		} catch (Exception e) {
			entityManager.close();
		}
		// -----------End transaction-----------

		return systemAccount;

	}

	/**
	 * @author TrinhLe search account for 7 fields condition
	 * 
	 * @param idCardNumber
	 *            fullname accountType accountNumber state
	 * @param phone
	 *            address
	 * @return list of accounts
	 */
	// ID Card number, Name, Account type/number, state, phone & address
	public List<Account> getAccount(String idCardNumber, String fullname,
			int accountType, String accountNumber, int state, String phone,
			String address) {

		// Obtains entity manager object
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		List<Account> accounts = null;
		// -----------Begin transaction-----------
		// boolean check = false;
		try {
			entityTransaction.begin();

			TypedQuery<Account> query = entityManager
					.createQuery(
							"SELECT c FROM "
									+ Account.class.getName()
									+ " c WHERE (c.firstName LIKE :fullname OR c.lastName LIKE :fullname OR c.midName LIKE :fullname) "
									+ "AND c.idCardNumber LIKE :idCardNumber AND (c.phoneNumber1 LIKE :phone OR c.phoneNumber2 LIKE :phone) "
									+ "AND (c.address1 LIKE :address OR c.address2 LIKE :address) AND c.accountNumber LIKE :accountNumber "
									+ "AND c.accountstate = "
									+ state + " AND c.accounttype = "
									+ accountType, Account.class);
			query.setParameter("fullname", "%" + fullname + "%");
			query.setParameter("idCardNumber", "%" + idCardNumber + "%");
			query.setParameter("phone", "%" + phone + "%");
			query.setParameter("address", "%" + address + "%");
			query.setParameter("accountNumber", "%" + accountNumber + "%");
			// query.setParameter("state", Integer.parseInt(state));
			// query.setParameter("accountType", Integer.parseInt(accountType));
			// query.setParameter("password", password);
			accounts = (List<Account>) query.getResultList();
			// System.out.println(systemAccount.getUsername());
			// check = query.getResultList().size() > 0;
			entityTransaction.commit();
		} catch (Exception e) {
			entityManager.close();
		}
		// -----------End transaction-----------

		return accounts;

	}
}
