package com.csc.fresher.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csc.fresher.dao.SystemAccountDAO;
import com.csc.fresher.domain.Account;

/**
 * @author TrinhLe
 * 
 *
 */
@Controller
public class SearchAccountController {

	/**
	 * redirect search page
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("null")
	@RequestMapping(value = "/searchPage")
	public String searchAccountList(HttpServletRequest request, Model model) {

		String role = (String) request.getSession().getAttribute("role");
		SystemAccountDAO systemDAO = new SystemAccountDAO();
		List<Account> accounts = new ArrayList<Account>();
		int records = systemDAO.getAccountsBaseOnDate().size();
		
		if (records > 0) {
			List<Account> listAcc = systemDAO.getAccountsBaseOnDate();
			for (int i = 0; i < 10; i++) {
				Account account = listAcc.get(i);
				accounts.add(account);
			}
			model.addAttribute("accounts", accounts);
			if (role.equals("admin"))
				return "adminSearch";
			else
				return "supportSearch";

		} else {

			return "search";
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
	public String getAccount(HttpServletRequest request, Model model) {
		// Read account info from request and save into Account object
		HttpSession session = request.getSession();
		String role = (String) request.getSession().getAttribute("role");
		String idCardNumber = request.getParameter("idCardNumber");
		String fullname = request.getParameter("fullname");
		int accountType = Integer.parseInt(request.getParameter("accountType"));
		String accountNumber = request.getParameter("accountNumber");
		int state = Integer.parseInt(request.getParameter("state"));
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		List<Account> accounts = null;
		String message = "";
		SystemAccountDAO systemDAO = new SystemAccountDAO();
		int records = systemDAO.getAccount(idCardNumber, fullname, accountType,
				accountNumber, state, phone, address).size();
		if (records > 0) {
			accounts = systemDAO.getAccount(idCardNumber, fullname,
					accountType, accountNumber, state, phone, address);
			model.addAttribute("accounts", accounts);
			model.addAttribute("state", state);
			if (role.equals("admin"))
				return "adminSearch";
			else
				return "supportSearch";

		} else {
			message = "No matching records found.";
			model.addAttribute("message", message);
			return "search";
		}
	}

}
