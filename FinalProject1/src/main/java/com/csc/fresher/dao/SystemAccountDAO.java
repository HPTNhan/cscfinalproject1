package com.csc.fresher.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.csc.fresher.domain.Account;
import com.csc.fresher.domain.SystemAccount;

@Component
public class SystemAccountDAO {

	@PersistenceContext
	private EntityManager tempEntityManager;

	@Transactional
	public List<SystemAccount> getSystemAccounts() {
		List<SystemAccount> systemaccounts = null;
		TypedQuery<SystemAccount> query = tempEntityManager.createQuery(
				"SELECT a FROM SystemAccount a", SystemAccount.class);
		systemaccounts = query.getResultList();

		return systemaccounts;
	}

	@Transactional
	public boolean addSystemAccount(SystemAccount systemAccount) {
		
		boolean result = true;
		tempEntityManager.persist(systemAccount);
		return result;
	}

	/**
	 * @author TrinhLe Login systemAccount
	 * 
	 * @param username
	 * @param password
	 * @return systemAccount
	 */
	@Transactional
	public SystemAccount getSystemAccount(String username, String password) {

		SystemAccount systemAccount = new SystemAccount();
		try {
			TypedQuery<SystemAccount> query = tempEntityManager
					.createQuery(
							"SELECT c FROM "
									+ SystemAccount.class.getName()
									+ " c Where c.username= :username and c.password= :password",
							SystemAccount.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			systemAccount = query.getSingleResult();
			
		} catch (Exception e) {
			return null;
		}
		return systemAccount;

	}

	/**
	 * not use multi-select for accountType and accountState
	 * 
	 * @author TrinhLe search account for 7 fields condition
	 * 
	 * @param idCardNumber
	 *            fullname accountType accountNumber state
	 * @param phone
	 *            address
	 * @return list of accounts
	 */
	/*
	 * public List<Account> getAccount(String idCardNumber, String fullname, int
	 * accountType, String accountNumber, int state, String phone, String
	 * address) {
	 * 
	 * // Obtains entity manager object EntityManager entityManager =
	 * EntityManagerFactoryUtil .createEntityManager();
	 * 
	 * EntityTransaction entityTransaction = entityManager.getTransaction();
	 * List<Account> accounts = null; String sql = "SELECT c FROM " +
	 * Account.class.getName() +
	 * " c WHERE (c.firstName LIKE :fullname OR c.lastName LIKE :fullname OR c.midName LIKE :fullname) "
	 * +
	 * "AND c.idCardNumber LIKE :idCardNumber AND (c.phoneNumber1 LIKE :phone OR c.phoneNumber2 LIKE :phone) "
	 * +
	 * "AND (c.address1 LIKE :address OR c.address2 LIKE :address) AND c.accountNumber LIKE :accountNumber "
	 * ; if(state > 0 && accountType > 0){ sql += "AND c.accountstate = " +
	 * state + " AND c.accounttype = " + accountType; } else if(state == 0 &&
	 * accountType > 0){ sql += " AND c.accounttype = " + accountType; }else
	 * if(accountType == 0 && state > 0){ sql += "AND c.accountstate = " +
	 * state; }
	 * 
	 * // -----------Begin transaction----------- // boolean check = false; try
	 * { entityTransaction.begin();
	 * 
	 * TypedQuery<Account> query = entityManager .createQuery(sql,
	 * Account.class); query.setParameter("fullname", "%" + fullname + "%");
	 * query.setParameter("idCardNumber", "%" + idCardNumber + "%");
	 * query.setParameter("phone", "%" + phone + "%");
	 * query.setParameter("address", "%" + address + "%");
	 * query.setParameter("accountNumber", "%" + accountNumber + "%"); accounts
	 * = (List<Account>) query.getResultList(); entityTransaction.commit(); }
	 * catch (Exception e) { entityManager.close(); } // -----------End
	 * transaction-----------
	 * 
	 * return accounts;
	 * 
	 * }
	 */
	
	
	/**
	 * @author TrinhLe search account for 7 fields condition
	 * 
	 * @param idCardNumber
	 *            fullname accountType accountNumber state
	 * @param phone
	 *            address
	 * @return list of accounts
	 */
	@Transactional
	public List<Account> getAccounts(String idCardNumber, String fullname,
			String[] accountType, String accountNumber, String[] state,
			String phone, String address) {

		List<Account> accounts = null;
		int i;
		String sql = "SELECT c FROM "
				+ Account.class.getName()
				+ " c WHERE (c.firstName LIKE :fullname OR c.lastName LIKE :fullname OR c.midName LIKE :fullname) "
				+ "AND c.idCardNumber LIKE :idCardNumber AND (c.phoneNumber1 LIKE :phone OR c.phoneNumber2 LIKE :phone) "
				+ "AND (c.address1 LIKE :address OR c.address2 LIKE :address) AND c.accountNumber LIKE :accountNumber AND c.isDeleted = 'false' ";
		if (state != null && accountType != null) {
			sql += "AND ( ";
			for (i = 0; i < state.length; i++) {
				sql += "c.accountstate = " + Integer.parseInt(state[i]);
				if (i < state.length - 1) {
					sql += " OR ";
				}
			}
			sql += ") AND ( ";
			for (i = 0; i < accountType.length; i++) {
				sql += "c.accounttype = " + Integer.parseInt(accountType[i]);
				if (i < accountType.length - 1) {
					sql += " OR ";
				}
			}
			sql += " )";
		} else if (state == null && accountType != null) {
			sql += "AND ( ";
			for (i = 0; i < accountType.length; i++) {
				sql += "c.accounttype = " + Integer.parseInt(accountType[i]);
				if (i < accountType.length - 1) {
					sql += " OR ";
				}
			}
			sql += " )";
		} else if (accountType == null && state != null) {
			sql += "AND ( ";
			for (i = 0; i < state.length; i++) {
				sql += "c.accountstate = " + Integer.parseInt(state[i]);
				if (i < state.length - 1) {
					sql += " OR ";
				}
			}
			sql += " )";
		}
		sql += " ORDER BY (c.timeStamp) DESC";

		try {

			TypedQuery<Account> query = tempEntityManager.createQuery(sql,
					Account.class);
			query.setParameter("fullname", "%" + fullname + "%");
			query.setParameter("idCardNumber", "%" + idCardNumber + "%");
			query.setParameter("phone", "%" + phone + "%");
			query.setParameter("address", "%" + address + "%");
			query.setParameter("accountNumber", "%" + accountNumber + "%");
			accounts = (List<Account>) query.getResultList();
			
		} catch (Exception e) {
			return null;
		}

		return accounts;

	}

	/**
	 * @author TrinhLe search 10 newest accounts
	 * 
	 * @param
	 * 
	 * @return list of accounts
	 */
	// ID Card number, Name, Account type/number, state, phone & address
	@Transactional
	public List<Account> getAccountsBaseOnDate() {

		List<Account> accounts = null;
		String sql = "SELECT c FROM " + Account.class.getName()
				+ " c WHERE c.isDeleted = 'false' ORDER BY (c.timeStamp) DESC";

		try {
			
			TypedQuery<Account> query = tempEntityManager.createQuery(sql,
					Account.class);
			accounts = (List<Account>) query.getResultList();
			
		} catch (Exception e) {
			return null;
		}

		return accounts;

	}

	/**
	 * @author TrinhLe search accounts base on state
	 * 
	 * @param state
	 * 
	 * @return size of list of accounts
	 */
	@Transactional
	public List<Account> getAccountsBaseOnState(int state) {

		List<Account> accounts = null;
		String sql = "SELECT c FROM " + Account.class.getName()
				+ " c WHERE c.isDeleted = 'false' AND c.accountstate = "
				+ state + " ORDER BY (c.timeStamp) DESC";
		;
		try {
			TypedQuery<Account> query = tempEntityManager.createQuery(sql,
					Account.class);
			accounts = (List<Account>) query.getResultList();
			
		} catch (Exception e) {
			return null;
		}
		// -----------End transaction-----------

		return accounts;

	}

}
