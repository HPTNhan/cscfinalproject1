package com.csc.fresher.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.fresher.dao.AccountStateDAO;
import com.csc.fresher.dao.NhanDAO;
import com.csc.fresher.dao.SystemAccountDAO;
import com.csc.fresher.domain.AccountState;
import com.csc.fresher.domain.SystemAccount;


@Controller
public class NhanController {	
	private static final NhanDAO nhanDao = new NhanDAO();
	
	@RequestMapping(value="/addSystemAccount", method=RequestMethod.GET)
	public String addSystemAccount(HttpServletRequest request) {
		SystemAccount systemAccount = new SystemAccount();
		systemAccount.setUsername("Nhan");
		systemAccount.setRole("admin");
		systemAccount.setPassword("12345678");
		
		SystemAccountDAO systemAccountDAO = new SystemAccountDAO();
		systemAccountDAO.addSystemAccount(systemAccount);
		
		request.setAttribute("SystemAccount", systemAccount);
		
		return "NhanRemoveAccount";
	}
	
	@RequestMapping(value="/getAccountState", method=RequestMethod.GET)
	public String getAccountState(HttpServletRequest request) {
		AccountStateDAO accountStateDAO = new AccountStateDAO();
		AccountState accountState = accountStateDAO.getAccountStateByName("new");
		
		
		request.setAttribute("SystemAccount", accountState);
		
		return "NhanRemoveAccount";
	}
	
	
	@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
	public String deleteAccount(HttpServletRequest request){
		
		boolean result = nhanDao.removeAccount(1);
		request.setAttribute("removeAccount", result);
		return "NhanRemoveAccount";
	}
	
}