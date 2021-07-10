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
// configuration annotation'ýný tanýmladýðýmýzda bu class spring için configuration class i tanýmlamakta.
//burada bean tanýmlarýný yapacaðýz anlamýna gelmektedir.
@PropertySource(value="classpath:employee.properties")
//property dosyaalrýný yðklemek için kullanýlýr.

@ComponentScan(basePackages = "javabased.model")//context:component scan tagýna karþýlýk gelir.

@ImportResource // ek konfigurasayon xml için kullanýlýr.
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
