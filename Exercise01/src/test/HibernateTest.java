package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Address;
import model.Employee;

public class HibernateTest {
public static void main(String[] args) {
	
	SessionFactory sessionFactory = new Configuration().configure("hibernateconfiguration.xml").buildSessionFactory();
	
	Session session = sessionFactory.getCurrentSession();
	
	Address address = new Address("Isýltý" , "Maltepe" , "Istanbul");
	
	Employee employee = new Employee("mehmet", "boluk", "mehemtblkk@gmail.com", address.toString());
	
	session.getTransaction().begin();
	session.persist(employee);
	session.getTransaction().commit();
	
	sessionFactory.close();
}
}
