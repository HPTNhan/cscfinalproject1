package com.csc.fresher.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csc.fresher.domain.SystemAccount;

@Repository
public class UserDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public SystemAccount findByUserName(String username) {

		List<SystemAccount> users = new ArrayList<SystemAccount>();
		

		TypedQuery<SystemAccount> query = entityManager.createQuery("SELECT a FROM "
				+ SystemAccount.class.getName() + " a WHERE a.username= :username", SystemAccount.class);
		query.setParameter("username", username);

		users = query.getResultList();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
}
