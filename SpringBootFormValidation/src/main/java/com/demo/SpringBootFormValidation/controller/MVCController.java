package com.demo.SpringBootFormValidation.controller;

import com.demo.SpringBootFormValidation.beans.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class MVCController {

    @GetMapping("/")
    public String sayHello() {
        return  "index";
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        List<String> professionList = Arrays.asList("Developer", "Designer", "Tester", "Architect");
        model.addAttribute("professionList", professionList);
        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        System.out.println("Processing form...");
        System.out.println(user);

        if (bindingResult.hasErrors()) {
            List<String> professionList = Arrays.asList("Developer", "Designer", "Tester", "Architect");
            model.addAttribute("professionList", professionList);
            return "register_form";
        }
        return "register_success";
    }

}
