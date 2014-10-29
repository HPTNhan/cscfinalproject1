package com.csc.fresher.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csc.fresher.domain.Account;
import com.csc.fresher.service.MyService;

/**
 * @author TrinhLe
 * 
 *
 */
@Controller
public class SearchAccountController {

	@Autowired
	private MyService service;

	/**
	 * redirect search page and show list of 10 newest accounts
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/searchPage")
	public String searchAccountsBaseOnDate(HttpServletRequest request,
			Model model) {
		String role = (String) request.getSession().getAttribute("role");
		if(role == null) return "redirect:home.jsp";
		
		// get list of accounts base on date (10 newest accounts)
		List<Account> accounts = service.searchAccountsBaseOnDate();
//		getNotification(model);
		// add attribute to show list of account for admin / support
		if (accounts != null) {
			model.addAttribute("accounts", accounts);
		} else {
			model.addAttribute("message", "No records found.");
		}
		if (role.equals("admin")) {
			model.addAttribute("flat", service
					.getStateForAccountListAdmin(service.getState(accounts)));
			return "adminSearch";
		} else {
			model.addAttribute("flat", service
					.getStateForAccountListSupport(service.getState(accounts)));
			return "supportSearch";
		}
	}

	/**
	 * search Account base on idCardNumber fullname address phone state accountNumber accountType
	 * 
	 * @param request
	 * @param model
	 * @return view list of accounts
	 */
	@RequestMapping(value = "/search")
	public String searchAccounts(HttpServletRequest request, Model model) {
		
		String role = (String) request.getSession().getAttribute("role");
		
		if(role == null) return "home";
		
		
		// Read conditions from request
		String idCardNumber = request.getParameter("idCardNumber");
		String fullname = request.getParameter("fullname");
		String accountNumber = request.getParameter("accountNumber");
		String[] accountType = request.getParameterValues("accountType");
		String[] state = request.getParameterValues("state");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		// search list of accounts base on conditions
		List<Account> accounts = service.searchAccounts(idCardNumber, fullname,
				accountType, accountNumber, state, phone, address);
		// check notification for all account's states
//		getNotification(model);
		// add attribute to show list of account for admin / support
		if (accounts != null) {
			model.addAttribute("accounts", accounts);
		} else {
			model.addAttribute("message", "No matching records found.");
		}
		if (role.equals("admin")) {
			model.addAttribute("flat", service
					.getStateForAccountListAdmin(service.getState(accounts)));
			return "adminSearch";
		} else {
			model.addAttribute("flat", service
					.getStateForAccountListSupport(service.getState(accounts)));
			return "supportSearch";
		}
	}

	/**
	 * search Account base on state (new, active, disable, removable
	 * 
	 * @param request
	 * @param model
	 * @return view list of accounts
	 */
	@RequestMapping(value = "/searchState")
	public String searchAccountsBaseOnState(HttpServletRequest request,
			Model model) {
		
		String role = (String) request.getSession().getAttribute("role");
		if(role == null) return "home";
		// Read conditions from request
		int state = Integer.parseInt(request.getParameter("state"));
		
		// add attribute to show list of account for admin / support
		if (service.searchAccountsBaseOnState(state) != null) {
			model.addAttribute("accounts",
					service.searchAccountsBaseOnState(state));
			model.addAttribute("flat", Integer.toString(state));
		} else {
			model.addAttribute("message", "No matching records found.");
		}
		if (role.equals("admin")) {
			return "adminSearch";
		} else {
			return "supportSearch";
		}
	}
	

}
