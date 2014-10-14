package com.csc.fresher.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



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
	
	
	
	/**
	 * 
	 * @param request
	 * @param model
	 * @return
	 * 
	 * @author 
	 */
	
	@RequestMapping(value = "/getAccountInfo")
	public String getAccountInfo(HttpServletRequest request,
			Model model) {
		
		int accountId = 377;
		//String accountId = request.getParameter("accountId");
		//String message = "";
//		if(request.getParameter("mess") == null){
//			message = "";
//		}else{
//			message = request.getParameter("mess");
//			
//		}
		AccountDAO accDAO = new AccountDAO();
		Account acc = accDAO.getAccountInfoByAccountId(accountId);
		model.addAttribute("accountInfo", acc);
		//model.addAttribute("message", message);
	
		System.out.println("get acc info uccessfully");
		return ("editAccount");
	}
	
	
	
	@RequestMapping(value = "/editAccount")
	public String editAccount(Model model) {

		return "editAccount";
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
		
		String message = "";
		
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

		try{
			// Save account to DB
			accountDAO.addAccount(account);
			message = "Add account successfully";
		}
		catch (Exception e){
			message = "Error: " + e;
		}
		
		model.addAttribute("message", message);
		//return ("forward:/addAccount.html");
		//return "forward:/home.html";
		//return "home";
		return "home";
	}

	
	
	
	


}
