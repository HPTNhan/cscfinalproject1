package com.csc.fresher.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.fresher.dao.AccountDAO;
import com.csc.fresher.dao.AccountStateDAO;
import com.csc.fresher.dao.SystemAccountDAO;
import com.csc.fresher.domain.Account;
import com.csc.fresher.domain.AccountState;
import com.csc.fresher.domain.SystemAccount;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private AccountStateDAO accountStateDAO;
	@Autowired
	private SystemAccountDAO systemAccountDAO;

	private AccountService() {

	}

	/**
	 * @param listIdAccount
	 * @return
	 * @author NhanHo
	 */
	public boolean deleteListAccount(String[] listIdAccount) {
		if (listIdAccount != null && listIdAccount.length > 0) {
			return accountDAO.deleteListAccount(listIdAccount);
		} else {
			return false;
		}
	}

	/**
	 * @author TrinhLe params username params password return system account
	 */
	/*public String checkLogin(String username, String password) {
		SystemAccount sysAccount = systemAccountDAO.getSystemAccount(username,
				password);
		if (sysAccount != null && sysAccount.getId() > 0) {
			return systemAccountDAO.getSystemAccount(username, password)
					.getRole();
		} else {
			return "false";
		}
	}*/

	/**
	 * @author TrinhLe params return 10 newest accounts
	 */
	public List<Account> searchAccountsBaseOnDate() {
		List<Account> accounts = new ArrayList<Account>();
		List<Account> listAcc = systemAccountDAO.getAccountsBaseOnDate();
		if (listAcc != null && listAcc.size() > 0) {
			if (listAcc.size() > 10) {
				for (int i = 0; i < 10; i++) {
					Account account = listAcc.get(i);
					accounts.add(account);
				}
				return accounts;
			} else
				return listAcc;
		} else {
			return null;
		}
	}

	/**
	 * @author TrinhLe params idCardNumber fullname accountType accountNumber
	 *         state phone address return list of accounts base on this
	 *         conditions
	 */
	public List<Account> searchAccounts(String idCardNumber, String fullname,
			String[] accountType, String accountNumber, String[] state,
			String phone, String address) {
		if (systemAccountDAO.getAccounts(idCardNumber, fullname, accountType,
				accountNumber, state, phone, address) != null
				&& systemAccountDAO.getAccounts(idCardNumber, fullname,
						accountType, accountNumber, state, phone, address)
						.size() > 0) {
			return systemAccountDAO.getAccounts(idCardNumber, fullname,
					accountType, accountNumber, state, phone, address);
		} else {
			return null;
		}
	}

	/**
	 * @author TrinhLe params state return flat to show button for each state
	 *         (admin page)
	 */
	public String getStateForAccountListAdmin(String state) {
		String flat = "";
		if (state != "") {
			if ((state.contains("2") && state.contains("1") && state
					.contains("3"))
					|| (state.contains("2") && state.contains("3")))
				flat = "123";
			else if ((state.contains("1") && state.contains("3"))
					|| (state.contains("3")))
				flat = "3";
			else if (state.contains("2") && state.contains("1"))
				flat = "12";
			else if ((state.contains("1")))
				flat = "1";
			else if ((state.contains("2")))
				flat = "2";
		} else
			flat = "123";
		return flat;
	}

	/**
	 * @author TrinhLe params state return flat to show button for each state
	 *         (support page)
	 */
	public String getStateForAccountListSupport(String state) {
		String flat = "";
		if (state != "") {
			if (state.contains("4"))
				flat = "4";
		} else
			flat = "4";
		return flat;
	}

	/**
	 * @author TrinhLe params state return a string contains state from list of
	 *         account
	 */
	public String getState(List<Account> accounts) {
		String temp = "";
		if (accounts != null) {
			for (int i = 0; i < accounts.size(); i++) {
				temp += Integer.toString(accounts.get(i).getAccountstate()
						.getIdstate());
			}
		} else
			temp += "5";
		return temp;
	}

	/**
	 * @author TrinhLe params state return a string contains state from list of
	 *         account
	 */
	public List<Account> searchAccountsBaseOnState(int state) {

		if (systemAccountDAO.getAccountsBaseOnState(state) != null
				&& systemAccountDAO.getAccountsBaseOnState(state).size() > 0)
			return systemAccountDAO.getAccountsBaseOnState(state);
		else
			return null;
	}

	/**
	 * @author TrinhLe params state return a string contains state from list of
	 *         account
	 */
	public int getSizeAccountsBaseOnState(List<Account> accounts) {

		if (accounts != null)
			return accounts.size();
		else
			return 0;
	}

	/**
	 * @param idaccount
	 * @return
	 * @author NhanHo
	 */
	public boolean deleteAccount(String idaccount) {
		// TODO Auto-generated method stub
		if (idaccount != null) {
			return accountDAO.deleteAccount(idaccount);
		}
		return false;
	}

	// --------------Qui----------------------

	public String getAccountNumber() {
		String accountNumber = accountDAO.getAccountNumber();
		return accountNumber;
	}

	public Account getAccountInfoByAccountId(int accountId) {
		Account account = accountDAO.getAccountInfoByAccountId(accountId);
		return account;
	}

	public boolean checkAccountType(Account account) {
		if (account.getAccounttype().getIdtype() < 1
				|| account.getAccounttype().getIdtype() > 3) {
			return false;
		} else {
			return true;
		}
	}

	public AccountState createAccountStateNew() {
		AccountState accountState = accountStateDAO
				.getAccountStateByName("New");
		return accountState;
	}

	public boolean checkAccountId(int accountId) {
		if (accountDAO.checkAccountId(accountId)) {
			return true;
		} else
			return false;
	}
	
	public boolean checkExistAccountNumber(Account account) {
		if (accountDAO.existAccountNumber(account.getAccountNumber())) {
			return true;
		} else
			return false;
	}

	public void addAccount(Account account) {
		accountDAO.addAccount(account);
	}

	public void updateAccountInfo(Account account) {
		accountDAO.updateAccountInfo(account);
	}

	public boolean setAccountStateById(String idaccount, String currentState,
			String nextState) {
		// TODO Auto-generated method stub
		return accountDAO.setAccountStateById(idaccount, currentState,
				nextState);
	}

	/**
	 * @param listIdAccount
	 * @param action
	 * @return
	 * @author NhanHo
	 */
	public boolean setListAccountStateById(String[] listIdAccount, String action) {
		// TODO Auto-generated method stub
		if (action.equals("Active") || action.equals("Disable")
				|| action.equals("Removable")) {
			return accountDAO.setListAccountStateById(listIdAccount, action);
		}
		return false;
	}
}
