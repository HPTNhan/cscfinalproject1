package com.csc.fresher.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.csc.fresher.service.AccountService;
/**
 * @author TrinhLe
 * 
 *
 */
@Component
@Aspect
public class NotifyAOP {

	@Autowired
	private AccountService service;
		
	@Before("execution(* com.csc.fresher.controller.*AccountController.*(..))  && args(*, model)")
	public void getMethodName(JoinPoint joinPoint, Model model){
		
		System.out.println("Method name: " + joinPoint.getSignature().getName());
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
		System.out.println("===========================================");
		
	}


}
