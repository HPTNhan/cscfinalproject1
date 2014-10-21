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
			// accountTemp.setAccountNumber(account.getAccountNumber());
			// accountTemp.setAccountstate(account.getAccountstate());
			accountTemp.setTimeStamp(account.getTimeStamp());
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

	/**
	 * get Account Number
	 * 
	 * @param
	 * 
	 * 
	 * @return sacc ( AccountNumber: String)
	 */
	public String getAccountNumber() {
		// Obtains entity manager object
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();
		// Obtains transaction from entity manager
		EntityTransaction enTr = entityManager.getTransaction();
		List<String> accountNumber = null;
		String sacc = "";
		try {
			enTr.begin();
			TypedQuery<String> query = entityManager.createQuery(
					"SELECT a.accountNumber FROM " + Account.class.getName()
							+ " a ORDER BY  a.idaccount DESC ", String.class);
			accountNumber = query.getResultList();
			enTr.commit();
			// generate Account Number by +1 and provide full 12 chars of number
			Long iacc = Long.parseLong(accountNumber.get(0));
			iacc += 1;
			sacc = iacc.toString();
			int accLength = sacc.length();
			int missLength = 12 - accLength;
			for (int i = 1; i <= missLength; i++) {
				sacc = "0" + sacc;
			}

		} catch (Exception e) {
			System.out.println(e);
			entityManager.close();
		}
		return sacc;
	}

	/**
	 * check existed AccountNumber
	 * 
	 * @param accountNumber
	 * 
	 * 
	 * @return bcheck
	 */
	public boolean existAccountNumber(String accountNumber) {
		// Obtains entity manager object
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();
		// Obtains transaction from entity manager
		EntityTransaction enTr = entityManager.getTransaction();
		boolean bcheck = false;
		try {
			enTr.begin();

			TypedQuery<Account> query = entityManager.createQuery(
					"SELECT a FROM " + Account.class.getName()
							+ " a Where a.accountNumber= :accountNumber ",
					Account.class);
			query.setParameter("accountNumber", accountNumber);
			bcheck = query.getResultList().size() > 0;
			enTr.commit();
		} catch (Exception e) {
			entityManager.close();
		}
		return bcheck;
	}

	/**
	 * get current Account state name
	 * 
	 * @param
	 * 
	 * 
	 * @return currentState ( StateName: String)
	 */
	public String getCurrentStateName(String idAccount) {
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();
		String currentState = "";
		entityManager.getTransaction().begin();

		Account account = entityManager.find(Account.class, idAccount);
		currentState = account.getAccountstate().getStateName();

		entityManager.getTransaction().commit();

		return currentState;
	}

	/**
	 * delete account by idaccount
	 * 
	 * @param String
	 *            idaccount
	 * 
	 * @return boolean ( boolean: true/false)
	 */
	public boolean deleteAccount(String idaccount) {
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			Account account = entityManager.find(Account.class, idaccount);

			entityTransaction.begin();

			entityManager.remove(account);

			entityTransaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			entityTransaction.rollback();
			return false;
		} finally {
			entityManager.close();
		}
		return true;
	}

	/**
	 * delete list account by idaccount
	 * 
	 * @param String
	 *            idaccount
	 * 
	 * @return boolean ( boolean: true/false)
	 */
	public boolean deleteListAccount(String[] listIdAccount) {
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();
			for (String idAccount : listIdAccount) {
				Account account = entityManager.find(Account.class,
						Integer.parseInt(idAccount));
				account.setIsDeleted("true");
				entityManager.merge(account);
			}
			entityTransaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			entityTransaction.rollback();
			return false;
		} finally {
			entityManager.close();
		}
		return true;
	}

}
