package ru.gg.demo.services;

import ru.gg.demo.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    public String sendNotification(User user) {
        return "A new user has benn created: " + user.getName();
    }
}
