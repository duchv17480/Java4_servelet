package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class jpaUtils {
	public static EntityManagerFactory getFactory() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ASS_PH17480");
		return factory;
	}
	public static EntityManager getEntityManager() {
		EntityManager em = jpaUtils.getFactory().createEntityManager();
		return em;
	}

}
