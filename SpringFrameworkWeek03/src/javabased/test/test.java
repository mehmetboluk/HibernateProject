package javabased.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javabased.configuration.JavaBasedConfiguration;
import javabased.model.Employee;

public class test {
public static void main(String[] args) {
	
	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaBasedConfiguration.class);
	

	Employee employee = applicationContext.getBean(Employee.class);
	
	System.out.println(employee);
	
}
}
