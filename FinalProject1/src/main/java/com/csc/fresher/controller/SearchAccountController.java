package com.csc.fresher.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csc.fresher.dao.SystemAccountDAO;

/**@author TrinhLe
 * 
 *
 */
@Controller
public class SearchAccountController {

	/**
	 * search Account
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/searchPage")
	public String searchAccountList(Model model) {
		
		return "search";
	}
	
	@RequestMapping(value = "/search")
	public String getAccount(HttpServletRequest request, Model model) {
		// Read account info from request and save into Account object
		HttpSession session = request.getSession();
		String idCardNumber = request.getParameter("idCardNumber");
		String fullname = request.getParameter("fullname");
		int accountType = Integer.parseInt(request.getParameter("accountType"));
		String accountNumber = request.getParameter("accountNumber");
		int state = Integer.parseInt(request.getParameter("state"));
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = "";
		SystemAccountDAO systemDAO = new SystemAccountDAO();
		int i = systemDAO.getAccount(idCardNumber, fullname, accountType, accountNumber, state, phone, address).size();
		System.out.println(i);
		return "search";
		
	}

}
