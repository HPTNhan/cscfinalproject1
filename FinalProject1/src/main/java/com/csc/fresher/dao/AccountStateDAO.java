package com.csc.fresher.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.csc.fresher.domain.AccountState;

@Component
public class AccountStateDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	/**
	 * @author NhanHo
	 * @param nameState
	 * @return
	 */
	@Transactional
	public AccountState getAccountStateByName(String nameState) {
		/*EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();*/

		AccountState accState = null;

		//entityTransaction.begin();
		try {
			TypedQuery<AccountState> query = entityManager.createQuery(
					"SELECT a FROM " + AccountState.class.getName()
							+ " a WHERE a.stateName= :stateName",
					AccountState.class);
			query.setParameter("stateName", nameState);
			accState = query.getSingleResult();

			//entityTransaction.commit();
		} catch (Exception e) {
			//entityManager.close();
			return null;
		}

		return accState;
	}
}
