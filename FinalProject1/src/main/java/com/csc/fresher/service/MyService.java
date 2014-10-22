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

	public String checkLogin(String username, String password) {
		if (systemAccountDAO.getSystemAccount(username, password).getId() > 0) {
			return systemAccountDAO.getSystemAccount(username, password)
					.getRole();
		} else {
			return "false";
		}
	}

	public List<Account> searchAccountsBaseOnDate() {
		List<Account> accounts = new ArrayList<Account>();
		if (systemAccountDAO.getAccountsBaseOnDate().size() > 0) {
			List<Account> listAcc = systemAccountDAO.getAccountsBaseOnDate();
			for (int i = 0; i < 10; i++) {
				Account account = listAcc.get(i);
				// temp += listAcc.get(i).getAccountstate().getIdstate();
				accounts.add(account);
			}
			return accounts;
		} else {
			return null;
		}
	}

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

	public String getStateForAccountListAdmin(String state) {
		String flat = "";
		if (state.length()>0) {
			if (state.contains("2") && state.contains("1")
					&& state.contains("3"))
				flat = "true";
			else if (state.contains("1") && state.contains("3"))
				flat = "false";
		} else
			flat = "true";
		return flat;
	}

	public String getStateForAccountListSupport(String state) {
		String flat = "";
		if (state != "") {
			if (state.contains("4"))
				flat = "true";
		} else
			flat = "true";
		return flat;
	}

	public String convertListState(String[] state) {
		String temp = "";

		for (int i = 0; i < state.length; i++) {
			temp += state[i];
		}
		return temp;
	}
	
	public String getState(List<Account> accounts) {
		String temp = "";
		for (int i = 0; i < accounts.size(); i++) {
			temp += Integer.toString(accounts.get(i).getAccountstate().getIdstate());
		}
		return temp;
	}

}
