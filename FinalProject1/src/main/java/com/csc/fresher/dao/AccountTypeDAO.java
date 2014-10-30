package com.csc.fresher.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.csc.fresher.domain.AccountType;


@Component
public class AccountTypeDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	public AccountType getAccountTypeIdbyAccountTypeName(String name) {


		/*EntityManager entityManager = EntityManagerFactoryUtil
				.createEntityManager();

		EntityTransaction entr = entityManager.getTransaction();*/

		AccountType id = null;
		try {
			//entr.begin();

			TypedQuery<AccountType> query = entityManager.createQuery(
					"SELECT c FROM " + AccountType.class.getName()
							+ " c Where c.typeName= :typeName",AccountType.class);
			
			query.setParameter("typeName", name);

			id = query.getSingleResult();

			//entr.commit();
		} catch (Exception e) {
			return null;
		}

		return id;

	}	
	
	
	
}
