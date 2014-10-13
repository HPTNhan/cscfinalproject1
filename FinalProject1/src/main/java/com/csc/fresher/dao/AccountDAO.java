package com.csc.fresher.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.csc.fresher.controller.EntityManagerFactoryUtil;
import com.csc.fresher.domain.Account;



/**
 * DAO class for Account entity. This class contains all methods that
 * inserts/updates/deletes account info
 * 
 * @author 
 *
 */
@Component
public class AccountDAO {

//	/**
//	 * @return all accounts from Account table
//	 */
//	public List<Account> getAccounts() {
//
//		// Obtains entity manager object
//		EntityManager entityManager = EntityManagerFactoryUtil
//				.createEntityManager();
//
//		// Obtains transaction from entity manager
//		EntityTransaction entr = entityManager.getTransaction();
//
//		// -----------Begin transaction-----------
//		List<Account> accounts = null;
//		try {
//			entr.begin();
//			// Get a list of accounts from DB
//			TypedQuery<Account> query = entityManager.createQuery(
//					"SELECT a FROM Account a", Account.class);
//			accounts = query.getResultList();
//			
//			entr.commit();
//		} catch (Exception e) {
//			entityManager.close();
//		}
//		// -----------End transaction-----------
//
//		return accounts;
//
//	}
	
	

	
	
//	public void updateUserName() {
//		EntityManager entityManager1 = EntityManagerFactoryUtil
//				.createEntityManager();
//		EntityTransaction entr = entityManager1.getTransaction();
//	  
//	     
//	     try {
//				// -----------Begin transaction-----------
//				entr.begin();
//				   Account user = entityManager1.find(Account.class, 4);
//				     Customer customer = entityManager1.getReference(Customer.class, "1");
//				     user.setAccountName("nghia");
//				     user.setAccountNumber("le");
//				     user.setAccountType("mama");
//				     user.setCustomer(customer);
//				     entityManager1.merge(user); 
//				entr.commit();
//			} catch (Exception e) {
//				entityManager1.close();
//			}
//	 }

	
	
	/**
	 * Add account to Account table
	 * 
	 * @param account
	 *            Account entity that contains mapped with each column in
	 *            Account table
	 * @return
	 */
	public boolean addAccount(Account account) {
		// Obtains entity manager object
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();

		// Obtains transaction from entity manager
		EntityTransaction entr = entityManager.getTransaction();
		System.out.println("aaa");
		try {
			// -----------Begin transaction-----------
			entr.begin();
			// Insert a row to Account table
			System.out.println("bbb");
			entityManager.persist(account);
			entr.commit();
			System.out.println("ccc");
		} catch (Exception e) {
			System.out.println( e);
			entityManager.close();
		}
		// -----------End transaction-----------

		return true;
	}
}
