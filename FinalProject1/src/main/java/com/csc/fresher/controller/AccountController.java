package com.csc.fresher.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.fresher.dao.AccountDAO;
import com.csc.fresher.dao.AccountStateDAO;
import com.csc.fresher.dao.AccountTypeDAO;
import com.csc.fresher.domain.Account;
import com.csc.fresher.domain.AccountState;
import com.csc.fresher.domain.AccountType;
import com.csc.fresher.service.MyService;

/**
 * Handles requests for the application home page.
 */
/**
 * @author cscadmin
 *
 */
@Controller
public class AccountController {

	// declare model Attribute
	@ModelAttribute("account")
	public Account contructAccount() {
		return new Account();
	}

	/**
	 * Simply selects the list of accounts view to render by returning its name.
	 */
	@Autowired
	private MyService service;

	@RequestMapping(value = "/doUpdateAccountInfo")
	public String doUpdateAccountInfo(Model model,
			@Valid @ModelAttribute("account") Account accountV,
			BindingResult result, HttpServletRequest request) throws Exception {
		// Read account info from request
		int iAccountType = accountV.getAccounttype().getIdtype();
		String accountNumber = accountV.getAccountNumber();
		String idCardNumber = accountV.getIdCardNumber();
		String firstName = accountV.getFirstName();
		String midName = accountV.getMidName();
		String lastName = accountV.getLastName();
		String phoneNumber1 = accountV.getPhoneNumber1();
		String phoneNumber2 = accountV.getPhoneNumber2();
		String address1 = accountV.getAddress1();
		String address2 = accountV.getAddress2();
		String email1 = accountV.getEmail1();
		String email2 = accountV.getEmail2();
		String idAccount = request.getParameter("idAccount");
		String message = "";
		// Get Id of AccountState where name State = New
		AccountStateDAO accountStateDAO = new AccountStateDAO();
		AccountState accountState = accountStateDAO
				.getAccountStateByName("New");
		// Get Id of AccountType where name = name in request
		AccountTypeDAO accountTypeDAO = new AccountTypeDAO();
		// AccountType accountType = accountTypeDAO
		// .getAccountTypeIdbyAccountTypeName(sAccountType);
		AccountType accountType = new AccountType();
		accountType.setIdtype(iAccountType);
		// Set isDeleted and Time
		String isDeleted = "false";
		// get current date time with Date()
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date timeStamp = new Date();

		// save Account info into Account object
		Account account = new Account(accountNumber, address1, address2,
				email1, email2, firstName, idCardNumber, isDeleted, lastName,
				midName, phoneNumber1, phoneNumber2, timeStamp, accountState,
				accountType);
		// set Account Id
		account.setIdaccount(Integer.parseInt(idAccount));

		if (iAccountType < 1 || iAccountType > 3) {
			String messageAS = "Account Type is not valid";
			model.addAttribute("message", messageAS);
			return "addAccount";
		}

		if (result.hasErrors()) {
			return "addAccount";
		} else {
			System.out.println("Input OK");
		}

		// Create an AccountDAO
		AccountDAO accountDAO = new AccountDAO();
		try {
			// Save account to DB
			accountDAO.updateAccountInfo(account);
			message = "Update account successfully";
		} catch (Exception e) {
			message = "Update account failed cause: " + e;
		}
		model.addAttribute("message", message);
		// return "editAccount";
		// return "redirect:/getAccountInfo";
		return "forward:/searchPage";
	}

	@RequestMapping(value = "/getAccountInfo")
	public String getAccountInfo(HttpServletRequest request, Model model) {
		// get id
		String SaccountId = request.getParameter("accountId");
		int accountId = Integer.parseInt(SaccountId);
		AccountDAO accDAO = new AccountDAO();
		Account acc = accDAO.getAccountInfoByAccountId(accountId);
		// add account to attribute of model
		model.addAttribute("accountInfo", acc);
		System.out.println("get acc info uccessfully");
		return ("editAccount");
	}

	@RequestMapping(value = "/getAddAccount")
	public String getAddAccount(HttpServletRequest request, Model model) {
		AccountDAO accountDAO = new AccountDAO();
		String accountNumber = accountDAO.getAccountNumber();
		model.addAttribute("accountNumber", accountNumber);
		return "addAccount";
	}

	@RequestMapping(value = "/doAddAccount")
	public String addAccount(Model model,
			@Valid @ModelAttribute("account") Account accountV,
			BindingResult result, HttpServletRequest request) throws Exception {
		// Read account info from request
		int iAccountType = accountV.getAccounttype().getIdtype();
		String accountNumber = accountV.getAccountNumber();
		String idCardNumber = accountV.getIdCardNumber();
		String firstName = accountV.getFirstName();
		String midName = accountV.getMidName();
		String lastName = accountV.getLastName();
		String phoneNumber1 = accountV.getPhoneNumber1();
		String phoneNumber2 = accountV.getPhoneNumber2();
		String address1 = accountV.getAddress1();
		String address2 = accountV.getAddress2();
		String email1 = accountV.getEmail1();
		String email2 = accountV.getEmail2();
		String message = "";

		// Get Id of AccountState where name State = New
		AccountStateDAO accountStateDAO = new AccountStateDAO();
		AccountState accountState = accountStateDAO
				.getAccountStateByName("New");
		// Get Id of AccountType where name = name in request
		AccountTypeDAO accountTypeDAO = new AccountTypeDAO();
		// AccountType accountType = accountTypeDAO
		// .getAccountTypeIdbyAccountTypeName(sAccountType);

		AccountType accountType = new AccountType();
		accountType.setIdtype(iAccountType);
		// Set isDeleted and Time
		String isDeleted = "false";
		// get current date time with Date()
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date timeStamp = new Date();
		// save Account info into Account object
		Account account = new Account(accountNumber, address1, address2,
				email1, email2, firstName, idCardNumber, isDeleted, lastName,
				midName, phoneNumber1, phoneNumber2, timeStamp, accountState,
				accountType);

		if (iAccountType < 1 || iAccountType > 3) {
			String messageAS = "Account Type is not valid";
			model.addAttribute("message", messageAS);
			return "addAccount";
		}

		if (result.hasErrors()) {
			return "addAccount";
		} else {
			System.out.println("Input OK");
		}

		// Create an AccountDAO
		AccountDAO accountDAO = new AccountDAO();
		// check exist Account Number
		if (accountDAO.existAccountNumber(accountNumber)) {
			message = "Account Number has existed";
			System.out.println("Account Number has existed");
		} else {
			try {
				// Save account to DB
				accountDAO.addAccount(account);
				message = "Create account successfully";

			} catch (Exception e) {
				message = "Create account failed cause: " + e;
			}
		}
		model.addAttribute("message", message);
		return "forward:/searchPage";
	}

	/**
	 * Delete list account by idAccount
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteListAccount", method = RequestMethod.POST)
	public String deleteListAccount(HttpServletRequest request) {
		String[] listIdAccountString = request.getParameterValues("idaccount");		
		if (service.deleteListAccount(listIdAccountString)) {
			System.out.println("delete completed");
		} else {
			System.out.println("delete failed");
		}
		return "redirect:/searchPage";
	}		
	
	@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
	public String deleteAccount(HttpServletRequest request) {
		String idaccount = request.getParameter("idaccount");		
		if (service.deleteAccount(idaccount)) {
			System.out.println("delete completed");
		} else {
			System.out.println("delete failed");
		}
		return "redirect:/searchPage";
	}
	
	
}
