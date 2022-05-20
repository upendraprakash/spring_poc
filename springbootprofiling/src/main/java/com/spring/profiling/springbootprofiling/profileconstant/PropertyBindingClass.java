package com.spring.profiling.springbootprofiling.profileconstant;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/app.properties")
public class PropertyBindingClass {
	@Autowired
    Environment env;

	@PostConstruct
	public void afterConstruct() {
		System.out.println(env.getProperty("app.example.type"));
	}
}
