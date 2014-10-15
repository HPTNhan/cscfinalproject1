package com.csc.fresher.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
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

	/**
	 * Add account to Account table
	 * 
	 * @param account
	 * 
	 * 
	 * @return bcheck
	 */
	public boolean addAccount(Account account) {
		boolean bcheck = false;
		// Obtains entity manager object
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();
		// Obtains transaction from entity manager
		EntityTransaction entr = entityManager.getTransaction();
		// -----------Begin transaction-----------
		try {
			entr.begin();
			// Insert a row to Account table
			entityManager.persist(account);
			entr.commit();
			bcheck = true;
			System.out.println("persist account successfully");
		} catch (Exception e) {
			System.out.println("error:" + "\n" + e);
			entityManager.close();
		}
		// -----------End transaction-----------
		return bcheck;
	}

	/**
	 * Get account info by ID
	 * 
	 * @param accountId
	 * 
	 * 
	 * @return acc
	 */
	public Account getAccountInfoByAccountId(int accountId) {
		// Obtains entity manager object
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();
		// Obtains transaction from entity manager
		EntityTransaction entr = entityManager.getTransaction();
		Account acc = null;
		try {
			entr.begin();
			System.out.println("aaa");
			acc = entityManager.find(Account.class, accountId);
			entr.commit();
			System.out.println("Get account info by ID successfully");
		} catch (Exception e) {
			System.out.println("error:" + "\n" + e);
			entityManager.close();
		}
		return acc;
	}

	/**
	 * Update account info
	 * 
	 * @param account
	 * 
	 * 
	 * @return bcheck
	 */
	public boolean updateAccountInfo(Account account) {
		// Obtains entity manager object
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();
		// Obtains transaction from entity manager
		EntityTransaction entr = entityManager.getTransaction();
		boolean bcheck = false;
		try {
			entr.begin();
			Account accountTemp = entityManager.find(Account.class,
					account.getIdaccount());
			System.out.print(account.getIdaccount());
			accountTemp.setAccountNumber(account.getAccountNumber());
			// accountTemp.setAccountstate(account.getAccountstate());
			accountTemp.setAccounttype(account.getAccounttype());
			accountTemp.setAddress1(account.getAddress1());
			accountTemp.setAddress2(account.getAddress2());
			accountTemp.setEmail1(account.getEmail1());
			accountTemp.setEmail2(account.getEmail2());
			accountTemp.setFirstName(account.getFirstName());
			accountTemp.setIdCardNumber(account.getIdCardNumber());
			accountTemp.setLastName(account.getLastName());
			accountTemp.setMidName(account.getMidName());
			accountTemp.setPhoneNumber1(account.getPhoneNumber1());
			accountTemp.setPhoneNumber2(account.getPhoneNumber2());
			bcheck = true;
			entr.commit();
			System.out.println("Update account info successfully");
		} catch (Exception e) {
			System.out.println("error:" + "\n" + e);
			entityManager.close();
		}
		return bcheck;
	}

}
