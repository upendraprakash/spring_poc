package com.spring.profiling.springbootprofiling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.profiling.springbootprofiling.profileconstant.CommonConstant;

@SpringBootApplication
public class SpringbootprofilingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootprofilingApplication.class, args);
	}

}
