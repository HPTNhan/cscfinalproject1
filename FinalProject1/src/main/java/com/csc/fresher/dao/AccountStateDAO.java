package com.csc.fresher.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.csc.fresher.controller.EntityManagerFactoryUtil;
import com.csc.fresher.domain.AccountState;

@Component
public class AccountStateDAO {

	public AccountState getAccountStateByName(String nameState) {
		EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		AccountState accState = null;

		entityTransaction.begin();
		try {
			TypedQuery<AccountState> query = entityManager.createQuery(
					"SELECT a FROM " + AccountState.class.getName()
							+ " a WHERE a.stateName= :stateName",
					AccountState.class);
			query.setParameter("stateName", nameState);
			accState = query.getSingleResult();

			entityTransaction.commit();
		} catch (Exception e) {
			entityManager.close();
		}

		return accState;
	}
}
