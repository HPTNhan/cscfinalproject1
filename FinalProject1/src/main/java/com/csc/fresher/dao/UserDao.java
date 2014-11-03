package com.csc.fresher.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csc.fresher.domain.User;

@Repository
public class UserDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();
		

		TypedQuery<User> query = entityManager.createQuery("SELECT a FROM "
				+ User.class.getName() + " a WHERE a.username= :username", User.class);
		query.setParameter("username", username);

		users = query.getResultList();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
}
