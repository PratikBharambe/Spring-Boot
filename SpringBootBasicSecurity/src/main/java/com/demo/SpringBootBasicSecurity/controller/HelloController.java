package com.demo.SpringBootBasicSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

    public String welcomeMesssage() {
        return "Welcomt to spring boot basic security";
    }

}
