package com.csc.fresher;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.csc.fresher.service.AccountService;

/**
 * @author TrinhLe
 * 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:servlet-context.xml")
public class SystemAccountDAOTest {
	@Autowired 
	AccountService accountService;
	
	@Test
	public void testLogin(){
		assertEquals("admin", accountService.checkLogin("admin", "123456"));
		assertEquals("support", accountService.checkLogin("support1", "sup123"));
		assertEquals("false", accountService.checkLogin("admin", "123"));
	}
	
	@Test
	public void testSearch(){
		
		String[] state = {"1","2"};
		assertEquals(61, accountService.searchAccounts("", "", null, "", null, "", "").size());
		assertEquals(43, accountService.searchAccounts("", "",state , "",null , "", "").size());
//		assertEquals("false", myService.checkLogin("admin", "123"));
	}

}
