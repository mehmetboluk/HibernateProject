package service;

import java.util.List;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	// Dao kýsmýnda server iþlmeleri yapýlýr service kýsmýnda kontroller loglamalar yapýlabilir.
	private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		employeeDao = new EmployeeDaoImpl();
	}
	
	private void checkSalary(Employee employee) {
		if(employee.getSalary() < 1000) {
			throw new RuntimeException("Invalid salary!!!");
		}
	}
	@Override
	public Employee save(Employee employee) {
		checkSalary(employee);
		return employeeDao.save(employee);
	}

	@Override
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public void remove(int id) {
		employeeDao.remove(id);
	}
	
	

}
