package com.csc.fresher.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csc.fresher.dao.SystemAccountDAO;
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
	 * redirect search page
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/searchPage")
	public String searchAccountList(HttpServletRequest request, Model model) {
		List<Account> accounts =  service.searchAccountsBaseOnDate();	
		String role = (String) request.getSession().getAttribute("role");
		String state;
		if (accounts.size() > 0) {
			model.addAttribute("accounts",accounts);
//			state = service.getState(accounts);
			model.addAttribute("state", "");
		} 
		if (role.equals("admin")){
			System.out.println("==="+service.getStateForAccountListAdmin(service.getState(accounts)));
			System.out.println("==="+service.getState(accounts).length());
			model.addAttribute("flat", service.getStateForAccountListAdmin(service.getState(accounts)));
			return "adminSearch";
		}
		else
			return "supportSearch";
	}

	/**
	 * search Account
	 * 
	 * @param request
	 * @param model
	 * @return view list of accounts
	 */
	@RequestMapping(value = "/search")
	public String getAccount(HttpServletRequest request, Model model) {
		// Read account info from request and save into Account object
		String role = (String) request.getSession().getAttribute("role");
		String idCardNumber = request.getParameter("idCardNumber");
		String fullname = request.getParameter("fullname");
		String accountNumber = request.getParameter("accountNumber");
		String[] accountType = request.getParameterValues("accountType");
		String[] state = request.getParameterValues("state");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = "";
		if (service.searchAccounts(idCardNumber, fullname, accountType,
				accountNumber, state, phone, address)!=null) {
			model.addAttribute("accounts", service
					.searchAccounts(idCardNumber, fullname, accountType,
							accountNumber, state, phone, address));
			model.addAttribute("state", state);
		} else {
			message = "No matching records found.";
			model.addAttribute("message", message);
		}
		if (role.equals("admin")){
			System.out.println( service.getStateForAccountListAdmin(service.convertListState(state)));
			model.addAttribute("flat", service.getStateForAccountListAdmin(service.convertListState(state)));
			return "adminSearch";
		}else{
			model.addAttribute("flat", service.getStateForAccountListSupport(service.convertListState(state)));
			return "supportSearch";
		}
	}

}
