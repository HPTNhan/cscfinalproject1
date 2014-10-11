package com.csc.fresher.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.csc.fresher.controller.EntityManagerFactoryUtil;
import com.csc.fresher.domain.SystemAccount;

@Component
public class SystemAccountDAO {
	public List<SystemAccount> getSystemAccounts() {
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		List<SystemAccount> systemaccounts = null;

		entityTransaction.begin();
		/*try {*/
			TypedQuery<SystemAccount> query = entityManager.createQuery(
					"SELECT a FROM SystemAccount a", SystemAccount.class);
			systemaccounts = query.getResultList();
			
			entityTransaction.commit();
		/*} catch (Exception e) {
			entityManager.close();
		}*/
		
		
		return systemaccounts;
	}
}
