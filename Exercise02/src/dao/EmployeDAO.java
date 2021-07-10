package dao;


import java.util.List;

import model.Employee;

public interface EmployeDAO {

	public Employee insertEmployee(int id , String name , String surname , int salary);
	
	public Employee findEmployee(int id);
	
	public List<Employee> findAllEmployees();
	
	public void removeEmployee(int id);
	
	public Employee raiseSalary(int id, int salary);
	
	
}
