package com.demo.SpringBootHelloMVC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello from Pratik Bharambe.";
	}
	
	@GetMapping("/firstsb")
	public String getMessage() {
		return "First spring boot web service";
	}
}

