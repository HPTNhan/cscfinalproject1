package com.csc.fresher;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.csc.fresher.domain.Account;
import com.csc.fresher.service.AccountService;

/**
 * @author Qui Huynh
 * 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Transactional
public class AccountDAOTest {
	@Autowired
	AccountService accountService;

	@Test
	public void existAccountNumberTest(){
		
		Account account1 = new Account( );
		account1.setAccountNumber("992384246398");
		Account account2 = new Account( );
		account2.setAccountNumber("999999999999");
		assertEquals(true, accountService.checkExistAccountNumber(account1));
		assertEquals(false, accountService.checkExistAccountNumber(account2));
	}
}
