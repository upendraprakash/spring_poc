package com.spring.profiling.springbootprofiling.profileconstant;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="my")
public class ProfilingClass {
private String app;
private String description;
private String username;
public String getApp() {
	return app;
}
public void setApp(String app) {
	this.app = app;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

@PostConstruct
public void profileData() {
	System.out.println("app name :: "+getApp()+" description :: "+getDescription()+" username :: "+getUsername());
}
}
