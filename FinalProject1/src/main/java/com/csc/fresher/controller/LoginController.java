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
public class LoginController {
	/**
	 * login systemAccount
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/checkLogin")
	public String getCustomer(HttpServletRequest request, Model model) {
		// Read account info from request and save into Account object
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String message = "";

		// Create an AccountDAO
		SystemAccountDAO systemDAO = new SystemAccountDAO();

		// Query customer to DB
		if(systemDAO.getSystemAccount(username, password)){
			session.setAttribute("username", username);
			message = "Success!";
			model.addAttribute("message", message );
			
			return "home";
		}
		else{
			
			message = "Wrong ID or Password!";
			model.addAttribute("message", message );
			return "home";
		}
	}
	@RequestMapping(value = "/search")
	public String searchAccountList(Model model) {
		
		return "search";
	}
	

}
