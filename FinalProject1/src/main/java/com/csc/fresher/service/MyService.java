package com.csc.fresher.service;

import org.springframework.stereotype.Service;

import com.csc.fresher.dao.AccountDAO;

@Service
public class MyService {
	
	//@Autowired
	private AccountDAO accountDAO = new AccountDAO();
	
	private MyService(){
		
	}
	
	public boolean deleteListAccount(String[] listIdAccount) {
		if (listIdAccount.length > 0) {
			return accountDAO.deleteListAccount(listIdAccount);
		} else {
			return false;
		}		
	}
	
}
