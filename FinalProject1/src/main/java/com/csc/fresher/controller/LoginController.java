package com.csc.fresher.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.fresher.dao.SystemAccountDAO;
import com.csc.fresher.service.MyService;

/**@author TrinhLe
 * 
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private MyService service;
	/**
	 * login systemAccount
	 * 
	 * @param request
	 * @param model
	 * @return search page if login success
	 * home page and show error message if login fail
	 */
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public String getCustomer(HttpServletRequest request, Model model) {
		// Read account info from request and save into Account object
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String message = "";
		if(!service.checkLogin(username, password).equals("false")){
			session.setAttribute("username", username);
			session.setAttribute("role", service.checkLogin(username, password));
			System.out.println(username + " login successful!");
			return "forward:/searchPage.html";
		}
		else{
			message = "Wrong ID or Password!";
			model.addAttribute("message", message );
			return "home";
		}
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.removeAttribute("role");
		session.removeAttribute("username");
		
		return "home";
	}
	

}
