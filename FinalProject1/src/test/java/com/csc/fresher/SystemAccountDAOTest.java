package com.csc.fresher;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.csc.fresher.service.AccountService;

/**
 * @author TrinhLe
 * 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Transactional
public class SystemAccountDAOTest {
	@Autowired 
	AccountService accountService;
	
	@Test
	public void testLogin(){
		/*assertEquals("admin", accountService.checkLogin("admin", "123456"));
		assertEquals("support", accountService.checkLogin("support1", "sup123"));
		assertEquals("false", accountService.checkLogin("admin", "123"));*/
	}
	
	@Test
	public void testSearch(){
		
		String[] state = {"1","2"};
		String[] type = {"3","2"};
		assertEquals(54, accountService.searchAccounts("", "", null, "", null, "", "").size());
		assertEquals(37, accountService.searchAccounts("", "",state , "",null , "", "").size());
		assertEquals(28, accountService.searchAccounts("", "",state , "",type , "", "").size());
		assertEquals(36, accountService.searchAccounts("", "",null , "",type , "", "").size());
	}

}
