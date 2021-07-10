package stereotype;

import org.springframework.stereotype.Repository;

import autowire_model.Employee;

@Repository(value="employeeDAOImpl")
public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("employeeDAO inserted...");
	}

}
