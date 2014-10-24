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
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.fresher.dao.AccountDAO;
import com.csc.fresher.domain.Account;
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
			@Valid @ModelAttribute("account") Account account,
			BindingResult result, HttpServletRequest request) throws Exception {
		String message = "";
		// check account type
		if (account.getAccounttype().getIdtype() < 1
				|| account.getAccounttype().getIdtype() > 3) {
			String messageAS = "Account Type is not valid";
			model.addAttribute("message", messageAS);
			return "redirect:/getAccountInfo";
		}
		// validate fields
		if (result.hasErrors()) {
			System.out.println(result.getFieldError().toString());
			System.out.println("Not OK");
			return "redirect:/getAccountInfo?accountId="
					+ account.getIdaccount();

		} else {
			// Construct some attributes
			String isDeleted = "false";
			Date timeStamp = new Date();
			// add Attributes for account
			account.setTimeStamp(timeStamp);
			account.setIsDeleted(isDeleted);
			// Create an AccountDAO
			AccountDAO accountDAO = new AccountDAO();
			try {
				// Save account to DB
				accountDAO.updateAccountInfo(account);
				message = "Update account successfully";
			} catch (Exception e) {
				message = "Update account failed cause: " + e;
			}
		}
		model.addAttribute("message", message);
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
			@Valid @ModelAttribute("account") Account account,
			BindingResult result, HttpServletRequest request) throws Exception {
		String message = "";
		// Check Account Type and Validate Account fields
		if (service.checkAccountType(account) == false || result.hasErrors()
				|| service.checkExistAccountNumber(account)) {
			if (service.checkAccountType(account) == false) {
				String messageAS = "Account Type is not valid";
				model.addAttribute("messageAS", messageAS);
			}
			if (service.checkExistAccountNumber(account)) {
				String messageAN = "Account Number has existed";
				model.addAttribute("messageAT", messageAN);
			}
			return "redirect:/getAddAccount";
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

	@RequestMapping(value = "/setAccountStateActive", method = RequestMethod.GET)
	public String setAccountStateActive(HttpServletRequest request) {
		String idaccount = request.getParameter("idaccount");
		if (idaccount != null) {
			service.setAccountStateById(idaccount, "New");
		}
		return "redirect:/searchPage";
	}

	@RequestMapping(value = "/setAccountStateActiveFromDisable", method = RequestMethod.GET)
	public String setAccountStateActiveFromDisable(HttpServletRequest request) {
		String idaccount = request.getParameter("idaccount");
		if (idaccount != null) {
			service.setAccountStateById(idaccount, "Disable");
		}
		return "redirect:/searchPage";
	}

	@RequestMapping(value = "/setAccountStateDisable", method = RequestMethod.GET)
	public String setAccountStateDisable(HttpServletRequest request) {
		String idaccount = request.getParameter("idaccount");
		if (idaccount != null) {
			service.setAccountStateById(idaccount, "Active");
		}
		return "redirect:/searchPage";
	}

	@RequestMapping(value = "/setAccountStateRemovable", method = RequestMethod.GET)
	public String setAccountStateRemovable(HttpServletRequest request) {
		String idaccount = request.getParameter("idaccount");
		if (idaccount != null) {
			service.setAccountStateById(idaccount, "Disable");
		}
		return "redirect:/searchPage";
	}

	@RequestMapping(value = "/setListAccountState", method = RequestMethod.GET)
	public String setListAccountState(HttpServletRequest request) {
		String[] idaccount = request.getParameterValues("idaccount");
		String action = request.getParameter("action");
		if (action.equals("removable")) {

		} else if (action.equals("active")) {

		} else if (action.equals("removable")) {

		}
		return "redirect:/searchPage";
	}

}
