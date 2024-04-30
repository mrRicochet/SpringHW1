package ru.gg.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello Spring Boot! \n <a href=\"/users\">Перейти к пользователям</a>";
    }

    @RequestMapping("/users")
    @ResponseBody
    public String users() {
        return "Страница с пользователями";
    }
}
