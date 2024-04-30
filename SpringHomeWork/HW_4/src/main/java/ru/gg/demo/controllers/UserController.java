package ru.gg.demo.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gg.demo.models.User;
import ru.gg.demo.services.UserService;

@Controller
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @PostMapping("/users")
    public String addUser(User user, Model model) {
        userService.addUser(user);
        model.addAttribute("users", userService.getUsers());
        return "users";
    }
}
