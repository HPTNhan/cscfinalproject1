package com.csc.fresher.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.fresher.service.AccountService;

@Controller
@RequestMapping(value="/support")
public class SupportController {
	
	@Autowired
	private AccountService service;
	/**
	 * Delete list account by idAccount
	 * 
	 * @param request
	 * @return
	 * @author NhanHo
	 */
	@RequestMapping(value = "/deleteListAccount", method = RequestMethod.POST)
	public String deleteListAccount(HttpServletRequest request) {

		/*String role = (String) request.getSession().getAttribute("role");
		if(role == null) return "home";
		if(!role.equals("support")) return "redirect:searchPage";*/
		
		String[] listIdAccountString = request.getParameterValues("idaccount");
		if (service.deleteListAccount(listIdAccountString)) {
			System.out.println("delete completed");
		} else {
			System.out.println("delete failed");
		}
		return "redirect:/searchPage";
	}
	
	/**
	 * @param request
	 * @return
	 * @author NhanHo
	 */
	@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
	public String deleteAccount(HttpServletRequest request) {

		/*String role = (String) request.getSession().getAttribute("role");
		if (role == null)
			return "home";
		if (!role.equals("support"))
			return "redirect:searchPage";*/

		String idaccount = request.getParameter("idaccount");
		if (service.deleteAccount(idaccount)) {
			System.out.println("delete completed");
		} else {
			System.out.println("delete failed");
		}
		return "redirect:/searchPage";
	}
}
