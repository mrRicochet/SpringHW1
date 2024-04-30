package ru.good.HW_7.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class MyController implements WebMvcConfigurer {
    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/public-data")
    public String publicPage() {
        return "public-data";
    }

    @GetMapping("/private-data")
    public String privatePage() {
        return "private-data";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}
