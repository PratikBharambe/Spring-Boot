package com.demo.MySpringBootHelloMVC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String greetHello() {
		return "Hello form this Side.!!!!";
	}
	
	@GetMapping("/hello")
	
	public String FirstSb() {
		return "My First Spring Boot MVC Web Application";
	}
	
	

}
