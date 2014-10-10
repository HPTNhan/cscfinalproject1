package com.csc.fresher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Handles requests for the application home page.
 */
@Controller
public class AccountController {
	
	
	/**
	 * Simply selects the list of accounts view to render by returning its name.
	 */
	
	@RequestMapping(value = "/view")
	public String getAccountList(Model model) {
		
		return "viewAllAccs";
	}
	
}
