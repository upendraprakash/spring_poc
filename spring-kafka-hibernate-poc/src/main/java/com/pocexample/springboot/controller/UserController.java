package com.pocexample.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pocexample.springboot.model.User;
import com.pocexample.springboot.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/getUserDetails")
	public ResponseEntity<List<User>> getAllProduct(){
		return ResponseEntity.ok().body(userService.getAllUser());
	}
	
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createProduct(@RequestBody User user){
		return ResponseEntity.ok().body(this.userService.createUser(user));
	}

}
