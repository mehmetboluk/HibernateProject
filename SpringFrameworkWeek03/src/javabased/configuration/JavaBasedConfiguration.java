package javabased.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javabased.model.Employee;


@Configuration
// configuration annotation'�n� tan�mlad���m�zda bu class spring i�in configuration class i tan�mlamakta.
//burada bean tan�mlar�n� yapaca��z anlam�na gelmektedir.
@PropertySource(value="classpath:employee.properties")
//property dosyaalr�n� y�klemek i�in kullan�l�r.

@ComponentScan(basePackages = "javabased.model")//context:component scan tag�na kar��l�k gelir.

@ImportResource // ek konfigurasayon xml i�in kullan�l�r.
public class JavaBasedConfiguration {
	
	@Autowired
	private Environment env;
	
	@Bean
	public Employee createEmployee() {
		
		System.out.println("#JavaBasedConfig#createEmployee");
		
		String name = env.getProperty("empname");
		String surname = env.getProperty("empsurname");
		
		return new Employee(name, surname);
	}
}
