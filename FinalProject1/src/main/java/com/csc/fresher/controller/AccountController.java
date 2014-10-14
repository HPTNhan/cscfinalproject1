package com.csc.fresher.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.fresher.domain.Account;
import com.csc.fresher.domain.AccountState;
import com.csc.fresher.domain.AccountType;
import com.csc.fresher.dao.AccountDAO;
import com.csc.fresher.dao.AccountStateDAO;
import com.csc.fresher.dao.AccountTypeDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AccountController {

	/**
	 * Simply selects the list of accounts view to render by returning its name.
	 */

	@RequestMapping(value = "/view")
	public String getAccountList(Model model) {

		return "viewAllAccs";
	}
	
	
	
	@RequestMapping(value = "/addAccount")
	public String getAddAccount(Model model) {

		return "addAccount";
	}
	
	
	
	

	/*
	 * Add account to database
	 * 
	 * @param request
	 * 
	 * @param model
	 * 
	 * @return
	 */
	@RequestMapping(value = "/doAddAccount")
	public String addAccount(HttpServletRequest request, Model model) {
		// Read account info from request 		
		String sAccountType = request.getParameter("accountType");
		String accountNumber = request.getParameter("accountNumber");
		String idCardNumber = request.getParameter("idCardNumber");
		String firstName = request.getParameter("firstName");
		String midName = request.getParameter("midName");
		String lastName = request.getParameter("lastName");
		String phoneNumber1 = request.getParameter("phoneNumber1");
		String phoneNumber2 = request.getParameter("phoneNumber2");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		
		
		
		// Get Id of AccountState where name State = New
		AccountStateDAO accountStateDAO = new AccountStateDAO();
		AccountState accountState = accountStateDAO
				.getAccountStateByName("New");
		// Get Id of AccountType where name = name in request
		AccountTypeDAO accountTypeDAO = new AccountTypeDAO();
		AccountType accountType = accountTypeDAO
						.getAccountTypeIdbyAccountTypeName(sAccountType);	
		

		// save Account info into Account object
		Account account = new Account(accountNumber, accountState,accountType,
				address1, address2, email1, email2, firstName, idCardNumber,
				lastName, midName, phoneNumber1, phoneNumber2);
		// Create an AccountDAO
		AccountDAO accountDAO = new AccountDAO();
		// Save account to DB
		accountDAO.addAccount(account);
		System.out.println("Add Successfully");
		return ("forward:/addAccount.html"+"&mess=Create Account Successfully");
	}

	
	
	
	
	@RequestMapping(value = "/editAccount")
	public String editAccount(Model model) {

		return "editAccount";
	}

}
