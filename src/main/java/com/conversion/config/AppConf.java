package com.conversion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.conversion.model.Employee;

@Configuration
public class AppConf {
	
	@Bean
	public Employee get()
	{
		return new Employee();
	}
	
	

}
