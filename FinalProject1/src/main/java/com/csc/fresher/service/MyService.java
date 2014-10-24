package com.csc.fresher.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.fresher.dao.AccountDAO;
import com.csc.fresher.dao.SystemAccountDAO;
import com.csc.fresher.domain.Account;

@Service
public class MyService {

	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private SystemAccountDAO systemAccountDAO;

	private MyService() {

	}

	public boolean deleteListAccount(String[] listIdAccount) {
		if (listIdAccount.length > 0) {
			return accountDAO.deleteListAccount(listIdAccount);
		} else {
			return false;
		}
	}

	/**
	 * @author TrinhLe params username params password return system account
	 */
	public String checkLogin(String username, String password) {
		if (systemAccountDAO.getSystemAccount(username, password).getId() > 0) {
			return systemAccountDAO.getSystemAccount(username, password)
					.getRole();
		} else {
			return "false";
		}
	}

	/**
	 * @author TrinhLe params return 10 newest accounts
	 */
	public List<Account> searchAccountsBaseOnDate() {
		List<Account> accounts = new ArrayList<Account>();
		List<Account> listAcc = systemAccountDAO.getAccountsBaseOnDate();
		if (listAcc != null && listAcc.size() > 0) {
			if(listAcc.size()>10){
			for (int i = 0; i < 10; i++) {
				Account account = listAcc.get(i);
				accounts.add(account);
			}
			return accounts;
			}
			else
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
				accountNumber, state, phone, address).size() > 0) {
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
	 * @author TrinhLe params state return a string contains state from string[]
	 *         state
	 */
	public String convertListState(String[] state) {
		String temp = "";
		if (state != null) {
			for (int i = 0; i < state.length; i++) {
				temp += state[i];
			}
		}
		return temp;
	}

	/**
	 * @author TrinhLe params state return a string contains state from list of
	 *         account
	 */
	public String getState(List<Account> accounts) {
		String temp = "";
		for (int i = 0; i < accounts.size(); i++) {
			temp += Integer.toString(accounts.get(i).getAccountstate()
					.getIdstate());
		}
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

	public boolean deleteAccount(String idaccount) {
		// TODO Auto-generated method stub
		if (idaccount != null) {
			return accountDAO.deleteAccount(idaccount);
		}
		return false;
	}

}
