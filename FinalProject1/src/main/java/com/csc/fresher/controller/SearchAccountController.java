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
	 * redirect search page
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/searchPage")
	public String searchAccountsBaseOnDate(HttpServletRequest request,
			Model model) {
		List<Account> accounts = service.searchAccountsBaseOnDate();
		if (request.getSession().getAttribute("role") != null) {
			String role = (String) request.getSession().getAttribute("role");
			getNotification(model);
			if (accounts.size() > 0) {
				model.addAttribute("accounts", accounts);
			}
			if (role.equals("admin")) {
				System.out.println("===" + service.getState(accounts));
				model.addAttribute("flat",
						service.getStateForAccountListAdmin(service
								.getState(accounts)));
				return "adminSearch";
			} else {
				System.out.println("===" + service.getState(accounts));
				model.addAttribute("flat", service
						.getStateForAccountListSupport(service
								.getState(accounts)));
				return "supportSearch";
			}
		} else {
			model.addAttribute("message", "You must login to access system!");
			return "home";
		}
	}

	/**
	 * search Account
	 * 
	 * @param request
	 * @param model
	 * @return view list of accounts
	 */
	@RequestMapping(value = "/search")
	public String searchAccounts(HttpServletRequest request, Model model) {
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
		getNotification(model);
		if (service.searchAccounts(idCardNumber, fullname, accountType,
				accountNumber, state, phone, address) != null) {
			model.addAttribute("accounts", service
					.searchAccounts(idCardNumber, fullname, accountType,
							accountNumber, state, phone, address));
			model.addAttribute("state", state);
		} else {
			message = "No matching records found.";
			model.addAttribute("message", message);
		}
		if (role.equals("admin")) {
			System.out.println(service.getStateForAccountListAdmin(service
					.convertListState(state)));
			model.addAttribute("flat", service
					.getStateForAccountListAdmin(service
							.convertListState(state)));
			return "adminSearch";
		} else {
			model.addAttribute("flat", service
					.getStateForAccountListSupport(service
							.convertListState(state)));
			return "supportSearch";
		}
	}

	@RequestMapping(value = "/searchState")
	public String searchAccountsBaseOnState(HttpServletRequest request,
			Model model) {
		int state = Integer.parseInt(request.getParameter("state"));
		String role = (String) request.getSession().getAttribute("role");
		String message = "";
		getNotification(model);
		if (service.searchAccountsBaseOnState(state) != null) {
			model.addAttribute("accounts",
					service.searchAccountsBaseOnState(state));
			model.addAttribute("flat", Integer.toString(state));
		} else {
			message = "No matching records found.";
			model.addAttribute("message", message);
		}
		if (role.equals("admin")) {
			return "adminSearch";
		} else {
			return "supportSearch";
		}
	}

	public void getNotification(Model model) {
		model.addAttribute("newAccount", service
				.getSizeAccountsBaseOnState(service
						.searchAccountsBaseOnState(1)));
		model.addAttribute("activeAccount", service
				.getSizeAccountsBaseOnState(service
						.searchAccountsBaseOnState(2)));
		model.addAttribute("disableAccount", service
				.getSizeAccountsBaseOnState(service
						.searchAccountsBaseOnState(3)));
		model.addAttribute("removableAccount", service
				.getSizeAccountsBaseOnState(service
						.searchAccountsBaseOnState(4)));

	}

}
