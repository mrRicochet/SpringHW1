package ru.gg.demo.services;


import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import ru.gg.demo.models.User;

@Service
@Data
public class UserService {
    List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

}
