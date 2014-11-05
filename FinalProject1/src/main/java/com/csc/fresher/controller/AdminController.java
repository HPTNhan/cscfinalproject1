package com.csc.fresher.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String setAccountStateActive(HttpServletRequest request, Model model) {
		
		/*String role = (String) request.getSession().getAttribute("role");
		if(role == null) return "home";
		if(!role.equals("admin")) return "redirect:searchPage";*/		
		String idaccount = request.getParameter("idaccount");
		String message = "";
		if (idaccount != null) {
			if (service.setAccountStateById(idaccount, "New", "Active")) {
				message = "Action successfully !";				
			} else {
				message = "Accounts had problem and could not be done !";	
			}
		}
		model.addAttribute("message", message);
		return "redirect:/searchPage";
	}
	
	/**
	 * @param request
	 * @return
	 * @author NhanHo
	 */
	@RequestMapping(value = "/setAccountStateActiveFromDisable", method = RequestMethod.GET)
	public String setAccountStateActiveFromDisable(HttpServletRequest request, Model model) {

		/*String role = (String) request.getSession().getAttribute("role");
		if(role == null) return "home";
		if(!role.equals("admin")) return "redirect:searchPage";*/		

		String idaccount = request.getParameter("idaccount");
		String message = "";
		if (idaccount != null) {			
			if (service.setAccountStateById(idaccount, "Disable", "Active")) {
				message = "Action successfully !";				
			} else {
				message = "Accounts had problem and could not be done !";	
			}
		}
		model.addAttribute("message", message);
		return "redirect:/searchPage";
	}
	
	/**
	 * @param request
	 * @return
	 * @author NhanHo
	 */
	@RequestMapping(value = "/setAccountStateDisable", method = RequestMethod.GET)
	public String setAccountStateDisable(HttpServletRequest request,Model model) {

		/*String role = (String) request.getSession().getAttribute("role");
		if(role == null) return "home";
		if(!role.equals("admin")) return "redirect:searchPage";*/				

		String idaccount = request.getParameter("idaccount");		
		String message = "";
		if (idaccount != null) {			
			if (service.setAccountStateById(idaccount, "Active", "Disable")) {
				message = "Action successfully !";				
			} else {
				message = "Accounts had problem and could not be done !";	
			}
		}
		model.addAttribute("message", message);
		return "redirect:/searchPage";
	}
	
	/**
	 * @param request
	 * @return
	 * @author NhanHo
	 */
	@RequestMapping(value = "/setAccountStateRemovable", method = RequestMethod.GET)
	public String setAccountStateRemovable(HttpServletRequest request, Model model) {

		/*String role = (String) request.getSession().getAttribute("role");
		if(role == null) return "home";
		if(!role.equals("admin")) return "redirect:searchPage";*/		

		String idaccount = request.getParameter("idaccount");
		String message = "";
		if (idaccount != null) {			
			if (service.setAccountStateById(idaccount, "Disable", "Removable")) {
				message = "Action successfully !";				
			} else {
				message = "Accounts had problem and could not be done !";	
			}
		}
		model.addAttribute("message", message);
		return "redirect:/searchPage";
	}
	
	/**
	 * @param request
	 * @return
	 * @author NhanHo
	 */
	@RequestMapping(value = "/setListAccountState", method = RequestMethod.POST)
	public String setListAccountState(HttpServletRequest request, Model model) {

		/*String role = (String) request.getSession().getAttribute("role");
		if(role == null) return "home";
		if(!role.equals("admin")) return "redirect:searchPage";*/
		
		String[] idaccount = request.getParameterValues("idaccount");
		String action = request.getParameter("action");		
		String message = "";
		if (idaccount != null) {			
			if (service.setListAccountStateById(idaccount, action)) {
				message = "Action successfully !";				
			} else {
				message = "Some accounts had problem and could not be done !";	
			}
		}
		model.addAttribute("message", message);
		model.asMap().clear();
		return "redirect:/searchPage";
	}
}
