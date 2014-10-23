package com.csc.fresher.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.fresher.dao.AccountStateDAO;
import com.csc.fresher.dao.NhanDAO;
import com.csc.fresher.dao.SystemAccountDAO;
import com.csc.fresher.domain.Account;
import com.csc.fresher.domain.AccountState;
import com.csc.fresher.domain.SystemAccount;

@Controller
public class NhanController {
	private static final NhanDAO nhanDao = new NhanDAO();

	@RequestMapping(value = "/addSystemAccount", method = RequestMethod.GET)
	public String addSystemAccount(HttpServletRequest request) {
		SystemAccount systemAccount = new SystemAccount();
		systemAccount.setUsername("Nhan");
		systemAccount.setRole("admin");
		systemAccount.setPassword("12345678");

		SystemAccountDAO systemAccountDAO = new SystemAccountDAO();
		systemAccountDAO.addSystemAccount(systemAccount);

		request.setAttribute("SystemAccount", systemAccount);

		return "NhanRemoveAccount";
	}

	@RequestMapping(value = "/getAccountState", method = RequestMethod.GET)
	public String getAccountState(HttpServletRequest request) {
		AccountStateDAO accountStateDAO = new AccountStateDAO();
		AccountState accountState = accountStateDAO
				.getAccountStateByName("new");

		request.setAttribute("SystemAccount", accountState);

		return "NhanRemoveAccount";
	}

	/*@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
	public String deleteAccount(HttpServletRequest request) {
		
		boolean result = nhanDao.removeAccount(1);
		request.setAttribute("removeAccount", result);
		return "NhanRemoveAccount";
	}*/
	
	// delete list accounts
	//
	//
	//
	//
	/*@RequestMapping(value="/deleteListAccounts", method = RequestMethod.POST )
	public String deleteListAccounts(HttpServletRequest request) {
		String[] listIdAccount = request.getParameterValues("");
		if (listIdAccount.length > 0) {
			for (String string : listIdAccount) {
				System.out.println(string);
			}			
		}else {
			System.out.println("no checked");
		}
		return "";
	}*/
	
	/*@RequestMapping(value = "/updateSystemAccount", method = RequestMethod.GET)
	public String updateSystemAccount() {
		NhanDAO dao = new NhanDAO();
		dao.updateSystemAccount(1);
		return "NhanRemoveAccount";
	}*/

	/*@RequestMapping(value = "/nhangetaccount", method = RequestMethod.GET)
	public String getAccountByIdCard(HttpServletRequest request) {
		String idCardNumber = "4445";

		Account account = nhanDao.getAccountByIdCard(idCardNumber);

		request.setAttribute("idCardNumber", account);
		return "NhanRemoveAccount";
	}*/

	/*
	 * @RequestMapping(value = "/nhanAdmin", method = RequestMethod.GET) public
	 * String getAdmin(HttpServletRequest request){ String idCardNumber =
	 * "4445";
	 * 
	 * Account account = nhanDao.getAccountByIdCard(idCardNumber);
	 * 
	 * request.setAttribute("idCardNumber", account);
	 * 
	 * return "search"; }
	 */



	/*@RequestMapping(value = "/AdminSetActive", method = RequestMethod.GET)
	public String AdminSetActive(HttpServletRequest request) {
		System.out.println(request.getParameter("idaccount"));
		return "NhanRemoveAccount";
	}*/
	
	/*@RequestMapping(value = "/AdminSetListActive", method = RequestMethod.POST)
	public String AdminSetListState(HttpServletRequest request) {
		String[] lisIdAccounts = request.getParameterValues("idaccount");	
		String action = request.getParameter("action");
		//String currentState = request.getParameter("currentState"); 
		if (lisIdAccounts != null && !action.equals("disableToActive")) {
			for (String idAccount : lisIdAccounts) {
				System.out.println(idAccount);
				if (nhanDao.setNextState(Integer.parseInt(idAccount))) {
					System.out.println("update success");
				} else {
					System.out.println("update failed");
				}
			}
			//System.out.println(currentState);
		}else if (lisIdAccounts != null && action.equals("disableToActive")) {
			for (String idAccount : lisIdAccounts) {
				System.out.println(idAccount);
				if (condition) {
					
				}
			}
		}else {
			System.out.println("No checkbox checked");
		}				
		return "NhanRemoveAccount";
	}*/
}
