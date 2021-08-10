package com.javainuse.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(value="/test", method=RequestMethod.POST )
	public String test(@RequestBody String data) {
		return "Hello World" +data;
	}
}
