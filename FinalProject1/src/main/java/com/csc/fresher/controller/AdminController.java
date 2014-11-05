package com.csc.fresher.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.fresher.service.AccountService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private AccountService service; 
	
	/**
	 * @param request
	 * @return
	 * @author NhanHo
	 */
	@RequestMapping(value = "/setAccountStateActive", method = RequestMethod.GET)
	public String setAccountStateActive(HttpServletRequest request) {
		
		/*String role = (String) request.getSession().getAttribute("role");
		if(role == null) return "home";
		if(!role.equals("admin")) return "redirect:searchPage";*/		
		String idaccount = request.getParameter("idaccount");
		if (idaccount != null) {
			service.setAccountStateById(idaccount, "New", "Active");
		}
		return "redirect:/searchPage";
	}
	
	/**
	 * @param request
	 * @return
	 * @author NhanHo
	 */
	@RequestMapping(value = "/setAccountStateActiveFromDisable", method = RequestMethod.GET)
	public String setAccountStateActiveFromDisable(HttpServletRequest request) {

		/*String role = (String) request.getSession().getAttribute("role");
		if(role == null) return "home";
		if(!role.equals("admin")) return "redirect:searchPage";*/		

		String idaccount = request.getParameter("idaccount");
		if (idaccount != null) {
			service.setAccountStateById(idaccount, "Disable", "Active");
		}
		return "redirect:/searchPage";
	}
	
	/**
	 * @param request
	 * @return
	 * @author NhanHo
	 */
	@RequestMapping(value = "/setAccountStateDisable", method = RequestMethod.GET)
	public String setAccountStateDisable(HttpServletRequest request) {

		/*String role = (String) request.getSession().getAttribute("role");
		if(role == null) return "home";
		if(!role.equals("admin")) return "redirect:searchPage";*/				

		String idaccount = request.getParameter("idaccount");
		if (idaccount != null) {
			service.setAccountStateById(idaccount, "Active", "Disable");
		}
		return "redirect:/searchPage";
	}
	
	/**
	 * @param request
	 * @return
	 * @author NhanHo
	 */
	@RequestMapping(value = "/setAccountStateRemovable", method = RequestMethod.GET)
	public String setAccountStateRemovable(HttpServletRequest request) {

		/*String role = (String) request.getSession().getAttribute("role");
		if(role == null) return "home";
		if(!role.equals("admin")) return "redirect:searchPage";*/		

		String idaccount = request.getParameter("idaccount");
		if (idaccount != null) {
			service.setAccountStateById(idaccount, "Disable", "Removable");
		}
		return "redirect:/searchPage";
	}
	
	/**
	 * @param request
	 * @return
	 * @author NhanHo
	 */
	@RequestMapping(value = "/setListAccountState", method = RequestMethod.POST)
	public String setListAccountState(HttpServletRequest request) {

		/*String role = (String) request.getSession().getAttribute("role");
		if(role == null) return "home";
		if(!role.equals("admin")) return "redirect:searchPage";*/
		
		String[] idaccount = request.getParameterValues("idaccount");
		String action = request.getParameter("action");
		if (idaccount != null) {
			service.setListAccountStateById(idaccount, action);
		}
		return "redirect:/searchPage";
	}
}
