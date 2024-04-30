package ru.good.HW_8.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.good.HW_8.aop.TrackUserAction;
import ru.good.HW_8.domain.User;
import ru.good.HW_8.repository.UserRepo;
import ru.good.HW_8.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    @TrackUserAction
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    @TrackUserAction
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    @TrackUserAction
    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    @TrackUserAction
    public void deleteUserById(Long id) {
        User user = getUserById(id);
        userRepo.delete(user);
    }
}
