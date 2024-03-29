package com.csc.fresher.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csc.fresher.domain.Account;
import com.csc.fresher.domain.AccountState;

/**
 * DAO class for Account entity. This class contains all methods that
 * inserts/updates/deletes account info
 * 
 * @author
 * 
 */
@Repository
public class AccountDAO {

	@PersistenceContext
	private EntityManager tempEntityManager;

	/**
	 * Add account to Account table
	 * 
	 * @param account
	 * 
	 * 
	 * @return bcheck
	 */
	@Transactional
	public boolean addAccount(Account account) {
		boolean bcheck = false;
		try {
			// Insert a row to Account table
			tempEntityManager.persist(account);
			bcheck = true;
			System.out.println("persist account successfully");
		} catch (Exception e) {
			System.out.println("error:" + "\n" + e);
		}
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
	@Transactional
	public Account getAccountInfoByAccountId(int accountId) {
		Account acc = null;
		try {
			acc = tempEntityManager.find(Account.class, accountId);
		} catch (Exception e) {
			System.out.println("error:" + "\n" + e);
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
	@Transactional
	public boolean updateAccountInfo(Account account) {
		boolean bcheck = false;
		try {
			Account accountTemp = tempEntityManager.find(Account.class,
					account.getIdaccount());
			System.out.print(account.getIdaccount());
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
			System.out.println("Update account info successfully");
		} catch (Exception e) {
			System.out.println("error:" + "\n" + e);
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
	@Transactional
	public String getAccountNumber() {
		List<String> accountNumber = null;
		String sacc = "";
		try {
			TypedQuery<String> query = tempEntityManager.createQuery(
					"SELECT a.accountNumber FROM " + Account.class.getName()
							+ " a ORDER BY  a.idaccount DESC ", String.class);
			accountNumber = query.getResultList();
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
	@Transactional
	public boolean existAccountNumber(String accountNumber) {
		boolean bcheck = false;
		try {
			TypedQuery<Account> query = tempEntityManager.createQuery(
					"SELECT a FROM " + Account.class.getName()
							+ " a Where a.accountNumber= :accountNumber ",
					Account.class);
			query.setParameter("accountNumber", accountNumber);
			bcheck = query.getResultList().size() > 0;
		} catch (Exception e) {
			System.out.println(e);
		}
		return bcheck;
	}

	/**
	 * check Account Id
	 * 
	 * @param accountNumber
	 * 
	 * 
	 * @return bcheck
	 */
	@Transactional
	public boolean checkAccountId(int accountId) {
		boolean bcheck = false;
		try {
			TypedQuery<Account> query = tempEntityManager.createQuery(
					"SELECT a FROM " + Account.class.getName()
							+ " a Where a.idaccount= :accountId ",
					Account.class);
			query.setParameter("accountId", accountId);

			bcheck = query.getResultList().size() > 0;
		} catch (Exception e) {
			System.out.println(e);
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
	@Transactional
	public String getCurrentStateName(String idAccount) {

		String currentState = "";

		try {
			Account account = tempEntityManager.find(Account.class, idAccount);
			currentState = account.getAccountstate().getStateName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return currentState;
	}

	/**
	 * delete account by idaccount
	 * 
	 * @param String
	 *            idaccount
	 * 
	 * @return boolean ( boolean: true/false)
	 * @author NhanHo
	 */
	@Transactional
	public boolean deleteAccount(String idaccount) {
		/*
		 * EntityManager entityManager = EntityManagerFactoryUtil
		 * .createEntityManager();
		 * 
		 * EntityTransaction entityTransaction = entityManager.getTransaction();
		 */
		Account account = tempEntityManager.find(Account.class,
				Integer.parseInt(idaccount));
		if (account == null) {
			return false;
		}
		try {		
			if (("Removable").equals(account.getAccountstate().getStateName())) {
				// entityTransaction.begin();
				Date timeStamp = new Date();
				account.setTimeStamp(timeStamp);
				account.setIsDeleted("true");
				tempEntityManager.merge(account);
				// entityManager.merge(account);
				// entityTransaction.commit();
			}
		} catch (Exception e) {
			return false;
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
	 * @author NhanHo
	 */
	@Transactional
	public boolean deleteListAccount(String[] listIdAccount) {

		try {
			for (String idAccount : listIdAccount) {
				Account account = tempEntityManager.find(Account.class,
						Integer.parseInt(idAccount));
				if (("Removable").equals(account.getAccountstate()
						.getStateName())) {
					Date timeStamp = new Date();
					account.setTimeStamp(timeStamp);
					account.setIsDeleted("true");
					tempEntityManager.merge(account);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	/**
	 * @param idaccount
	 * @return
	 * @author NhanHo
	 */
	@Transactional
	public boolean setAccountStateById(String idaccount, String currentState,
			String nextState) {
		// TODO Auto-generated method stub

		try {
			Account account = tempEntityManager.find(Account.class,
					Integer.parseInt(idaccount));
			if (account != null
					&& currentState.equals(account.getAccountstate()
							.getStateName())
					&& findStateByName(nextState) != null) {

				Date timeStamp = new Date();
				account.setTimeStamp(timeStamp);
				account.setAccountstate(findStateByName(nextState));
				tempEntityManager.merge(account);
				System.out.println(idaccount + currentState + nextState);
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	/**
	 * @param AccountState
	 * @return
	 * @author NhanHo
	 */
	@Transactional
	public AccountState findStateByName(String AccountState) {
		AccountState accountState = null;
		try {
			TypedQuery<AccountState> query = tempEntityManager.createQuery(
					"SELECT a FROM " + AccountState.class.getName()
							+ " a WHERE a.stateName= :stateName ",
					AccountState.class);
			query.setParameter("stateName", AccountState);
			accountState = query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return accountState;
	}

	/**
	 * @param idaccount
	 * @param action
	 * @return
	 * @author NhanHo
	 */
	@Transactional
	public boolean setListAccountStateById(String[] idaccounts, String action) {
		// TODO Auto-generated method stub
		/*
		 * EntityManager entityManager = EntityManagerFactoryUtil
		 * .createEntityManager(); EntityTransaction entityTransaction =
		 * entityManager.getTransaction();
		 */

		Boolean result = true;
		if (action.equals("Active")) {
			for (String idaccount : idaccounts) {
				Account account = tempEntityManager.find(Account.class,
						Integer.parseInt(idaccount));
				if (account != null) {
					String currentState = account.getAccountstate()
							.getStateName();
					if (currentState.equals("New")
							|| currentState.equals("Disable")) {
						if (!setAccountStateById(idaccount, currentState,
								action)) {
							result = false;
						}
					}
				}
			}
		} else if (action.equals("Disable")) {
			for (String idaccount : idaccounts) {
				Account account = tempEntityManager.find(Account.class,
						Integer.parseInt(idaccount));
				if (account != null) {
					String currentState = account.getAccountstate()
							.getStateName();
					if (currentState.equals("Active")) {
						if (!setAccountStateById(idaccount, currentState,
								action)) {
							result = false;
						}
					}
				}
			}
		} else if (action.equals("Removable")) {
			for (String idaccount : idaccounts) {
				Account account = tempEntityManager.find(Account.class,
						Integer.parseInt(idaccount));
				if (account != null) {
					String currentState = account.getAccountstate()
							.getStateName();
					if (currentState.equals("Disable")) {
						if (!setAccountStateById(idaccount, currentState,
								action)) {
							result = false;
						}
					}
				}
			}
		}
		return result;
	}

}
