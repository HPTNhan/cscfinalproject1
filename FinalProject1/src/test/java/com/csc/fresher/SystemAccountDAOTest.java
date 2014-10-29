package com.csc.fresher;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.csc.fresher.service.MyService;

/**
 * @author TrinhLe
 * 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:servlet-context.xml")
public class SystemAccountDAOTest {
	@Autowired 
	MyService myService;
	
	@Test
	public void testLogin(){
		assertEquals("admin", myService.checkLogin("admin", "123456"));
		assertEquals("support", myService.checkLogin("support1", "sup123"));
		assertEquals("false", myService.checkLogin("admin", "123"));
	}
	
	@Test
	public void testSearch(){
		
		String[] state = {"1","2"};
		assertEquals(61, myService.searchAccounts("", "", null, "", null, "", "").size());
		assertEquals(43, myService.searchAccounts("", "",state , "",null , "", "").size());
//		assertEquals("false", myService.checkLogin("admin", "123"));
	}

}
