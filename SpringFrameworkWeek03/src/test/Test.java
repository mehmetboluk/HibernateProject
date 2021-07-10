package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import autowire_model.Employee;

public class Test {
public static void main(String[] args) {
	
	ApplicationContext  appContext = new ClassPathXmlApplicationContext("autowiredmodel.xml");
	
	Employee employee = appContext.getBean("employee", Employee.class);
	
	System.out.println(employee);
}
}
