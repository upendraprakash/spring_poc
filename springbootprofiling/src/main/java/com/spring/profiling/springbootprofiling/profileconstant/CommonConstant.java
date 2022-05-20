package com.spring.profiling.springbootprofiling.profileconstant;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class CommonConstant {
	@Value("${app.profile}")
	private String name;

	public String getName() {
		return name;
	}
	
	@PostConstruct
	public void close() {
		System.out.println(getName());
	}
	
}
