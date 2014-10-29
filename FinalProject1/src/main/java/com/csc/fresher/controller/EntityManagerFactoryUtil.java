package com.csc.fresher.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Listener, responsible for creating an entity manager factory when application
 * starts and destroys when application ends
 * 
 * @author nvu3
 * 
 */
public class EntityManagerFactoryUtil implements ServletContextListener {

	private static EntityManagerFactory emf;

	/**
	 * Used to get entity manager
	 * 
	 * @return EntityManager
	 */
	public static EntityManager createEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("myjpa");
		}
		return emf.createEntityManager();
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		emf.close();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("myjpa");
	}

}
