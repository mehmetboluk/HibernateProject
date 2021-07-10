package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dao.EmployeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

public class Test {
public static void main(String[] args) {
	
	
	EntityManagerFactory emp = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
	EntityManager entityManager = emp.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	//---------------------------------------------------------------
	EmployeDAO employeeService = new EmployeeDAOImpl(entityManager);
	//---------------------------------------------------------------
	entityTransaction.begin();
	Employee e00 = employeeService.insertEmployee(0, "Mehmet", "Boluk", 5000);
	Employee e01 = employeeService.insertEmployee(1, "Huseyin", "Dari", 6000);
	Employee e02 = employeeService.insertEmployee(2, "Alp", "Dertli", 7000);
	entityTransaction.commit();
	//---------------------------------------------------------------
	System.out.println("Persisted : " + e00);
	System.out.println("Persisted : " + e01);
	System.out.println("Persisted : " + e02);
	//---------------------------------------------------------------
	Employee e04 = employeeService.findEmployee(2);
	System.out.println("Found : " + e04);
	//---------------------------------------------------------------
	entityTransaction.begin();
	Employee e05 = employeeService.raiseSalary(2, 5000);
	entityTransaction.commit();
	//---------------------------------------------------------------
	System.out.println("FIND ALL EMPLOYEES!!!");
	List <Employee> employees = employeeService.findAllEmployees();
	for (Employee employee : employees) {
		System.out.println("Found : " + employee);
	}
	
}
}
