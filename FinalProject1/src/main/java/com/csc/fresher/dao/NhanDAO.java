package com.csc.fresher.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Component;

import com.csc.fresher.controller.EntityManagerFactoryUtil;
import com.csc.fresher.domain.Account;


@Component
public class NhanDAO {
	
	public boolean removeAccount(int idaccount){
		EntityManager entityManager = EntityManagerFactoryUtil.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		
		Account account = entityManager.find(Account.class, idaccount);
		entityTransaction.begin();
		
		entityManager.remove(account);
		
		entityTransaction.commit();
		
		return true;
	}
	
}
