package com.csc.fresher.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.csc.fresher.domain.Account;
import com.csc.fresher.service.AccountService;

/**
 * Handles requests for the application account page
 */

@Controller
public class AccountController {
	private Account accountTemp;

	// declare model Attribute
	@ModelAttribute("account")
	public Account contructAccount() {
		return new Account();
	}

	/**
	 * Simply selects the list of accounts view to render by returning its name.
	 */
	@Autowired
	private AccountService service;

	/**
	 * Edit account info
	 * 
	 * @param request
	 * @return page
	 */
	@RequestMapping(value = "/doUpdateAccountInfo")
	public String doUpdateAccountInfo(Model model,
			@Valid @ModelAttribute("account") Account account,
			BindingResult result, HttpServletRequest request,
			final RedirectAttributes attr) throws Exception {

		/*String role = (String) request.getSession().getAttribute("role");
		if(role == null) return "home";
		if(!role.equals("support")) return "redirect:searchPage";*/				

		String message = "";
		String alert = "";
		// Check Account Type and Validate Account fields
		if (service.checkAccountType(account) == false || result.hasErrors()) {
			String messageAS = "";
			if (service.checkAccountType(account) == false) {
				messageAS = "Account Type is not valid";
				model.addAttribute("messageAS", messageAS);
			}
			// send Account Info
			model.addAttribute("accountInfo", accountTemp);
			// return "forward:/getAccountInfo?accountId="+
			// account.getIdaccount() + "&messageAS=" + messageAS;
			return "editAccount";
		} else {
			// Construct some attributes
			String isDeleted = "false";
			Date timeStamp = new Date();
			// add Attributes for account
			// account.setAccountstate(service.createAccountStateNew());
			account.setTimeStamp(timeStamp);
			account.setIsDeleted(isDeleted);
			try {
				// Save account to DB
				service.updateAccountInfo(account);
				message = "Update  account successfully";
				alert = "success";
			} catch (Exception e) {
				message = "Update  account failed, please try again";
				alert = "error";
			}
		}
		attr.addFlashAttribute("message", message);
		attr.addFlashAttribute("alert", alert);
		return "redirect:searchPage";
	}

	/**
	 * get Account Info page to edit
	 * 
	 * @param request
	 * @return page
	 */
	@RequestMapping(value = "/getAccountInfo")
	public String getAccountInfo(HttpServletRequest request, Model model,final RedirectAttributes attr) {

		/*String role = (String) request.getSession().getAttribute("role");		
		
		if (role == null)
			return "home";
		if (!role.equals("support"))
			return "redirect:searchPage";*/
		// get id
		String SaccountId = request.getParameter("accountId");
		int accountId = Integer.parseInt(SaccountId);
		if (service.checkAccountId(accountId)) {
			// add account to attribute of model
			model.addAttribute("accountInfo",
					service.getAccountInfoByAccountId(accountId));
			// set Account Info Temp to do Update Account in case account info
			// is not valid
			accountTemp = service.getAccountInfoByAccountId(accountId);
			return ("editAccount");
		} else {
			String message = "This Account doesn't exist";
			String alert = "error";
			attr.addFlashAttribute("message", message);
			attr.addFlashAttribute("alert", alert);
			return "redirect:searchPage";
		}
	}

	/**
	 * get Add account page
	 * 
	 * @param request
	 * @return page
	 */
	@RequestMapping(value = "/getAddAccount")
	public String getAddAccount(HttpServletRequest request, Model model) {

		/*
		 * String role = (String) request.getSession().getAttribute("role");
		 * if(role == null) return "home"; if(!role.equals("support")) return
		 * "redirect:searchPage";
		 */
		
		/*String role = (String) request.getSession().getAttribute("role");
		if (role == null)
			return "home";
		if (!role.equals("support"))
			return "redirect:searchPage";*/

		String accountNumber = service.getAccountNumber();
		model.addAttribute("accountNumber", accountNumber);
		return "addAccount";
	}

	/**
	 * Add account
	 * 
	 * @param request
	 * @return page
	 */
	@RequestMapping(value = "/doAddAccount")
	public String addAccount(Model model,
			@Valid @ModelAttribute("account") Account account,
			BindingResult result, HttpServletRequest request,
			final RedirectAttributes attr) throws Exception {

		/*String role = (String) request.getSession().getAttribute("role");
		if(role == null) return "home";
		if(!role.equals("support")) return "redirect:searchPage";*/
		

		String message = "";
		String alert = "";
		// Check Account Type and Validate Account fields
		if (service.checkAccountType(account) == false || result.hasErrors()
				|| service.checkExistAccountNumber(account)) {
			if (service.checkAccountType(account) == false) {
				String messageAS = "Account Type is not valid";
				model.addAttribute("messageAS", messageAS);
			}
			if (service.checkExistAccountNumber(account)) {
				String messageAN = "Account Number has existed";
				model.addAttribute("messageAN", messageAN);
			}
			return "addAccount";
		} else {
			// Construct some attributes

			String isDeleted = "false";
			Date timeStamp = new Date();
			// add Attributes for account
			account.setAccountstate(service.createAccountStateNew());
			account.setTimeStamp(timeStamp);
			account.setIsDeleted(isDeleted);
			try {
				// Save account to DB
				service.addAccount(account);
				message = "Create account successfully";
				alert = "success";
			} catch (Exception e) {
				alert = "error";
				message = "Create account failed, please try again";
			}
		}
		attr.addFlashAttribute("message", message);
		attr.addFlashAttribute("alert", alert);
		return "redirect:searchPage";
	}

}
