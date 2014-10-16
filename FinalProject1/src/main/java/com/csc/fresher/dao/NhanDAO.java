package com.csc.fresher.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.csc.fresher.controller.EntityManagerFactoryUtil;
import com.csc.fresher.domain.Account;
import com.csc.fresher.domain.SystemAccount;

@Component
public class NhanDAO {

	public boolean removeAccount(int idaccount) {
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		Account account = entityManager.find(Account.class, idaccount);
		entityTransaction.begin();

		entityManager.remove(account);

		entityTransaction.commit();

		return true;
	}

	public boolean updateSystemAccount(int id) {
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		SystemAccount account = entityManager.find(SystemAccount.class, id);

		account.setRole("SiuNhan");

		entityManager.merge(account);

		entityTransaction.commit();

		return true;
	}

	public Account getAccountByIdCard(String idCard) {
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();

		entityManager.getTransaction().begin();

		TypedQuery<Account> query = entityManager.createQuery("SELECT a FROM "
				+ Account.class.getName()
				+ " a WHERE a.idCardNumber like :idCardnumber", Account.class);

		query.setParameter("idCardnumber", idCard);
		
		Account account =  query.getSingleResult();
		
		entityManager.getTransaction().commit();
		
		return account;
	}
	
	

}
