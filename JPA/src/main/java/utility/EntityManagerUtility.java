package utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtility {
	
	//bos nesne oluþtrumamasý için
	private EntityManagerUtility() {
		throw new AssertionError();
	}

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
	
	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	
}
