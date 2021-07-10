package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

@WebServlet("/employeeServlet")
public class EmployeeServlet extends HttpServlet {

	private final EmployeeService employeeService = new EmployeeServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		int salary = Integer.parseInt(req.getParameter("salary"));
		
		Employee employee = new Employee("mehmet", "boluk", 5000);
		employeeService.save(employee);
	
		List <Employee> allEmployees = employeeService.findAll();
		
		req.setAttribute("allEmployees", allEmployees);
		
		RequestDispatcher requestDispatcher =  req.getRequestDispatcher("employee.jsp");
		requestDispatcher.forward(req, resp);
	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int employeeId = Integer.parseInt(req.getParameter("employeeId"));
		employeeService.remove(employeeId);
		
		List <Employee> allEmployees = employeeService.findAll();
		
		req.setAttribute("allEmployees", allEmployees);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("employee.jsp");
		requestDispatcher.forward(req, resp);
	
	}
	
}
