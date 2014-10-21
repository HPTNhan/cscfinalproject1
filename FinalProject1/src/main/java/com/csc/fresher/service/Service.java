package com.csc.fresher.service;

import com.csc.fresher.dao.AccountDAO;

public class Service {
		
	private AccountDAO accountDAO = new AccountDAO();
	
	public boolean deleteListAccount(String[] listIdAccount) {
		if (listIdAccount.length > 0) {
			return accountDAO.deleteListAccount(listIdAccount);
		} else {
			return false;
		}		
	}
	
}
