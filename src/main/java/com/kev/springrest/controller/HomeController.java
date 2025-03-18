package com.kev.springrest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/")
    public String Hello() {
        return "index";
    }

    @GetMapping("/helloworld/{firstname}")
    public String helloWorldFirstname(Model model,@PathVariable String firstname) {
        String formattedFirstname = firstname.substring(0, 1).toUpperCase() + firstname.substring(1);
        model.addAttribute("firstname",formattedFirstname);
        return "hellofirstname";
    }
}
