package ru.gg.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gg.demo.domain.User;
import ru.gg.demo.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {


    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }

    @PostMapping("/user/body")
    public String userAdd(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("email") String email)
    {
        service.processRegistration(name, age, email);
        return "User added from params!";
    }
}
