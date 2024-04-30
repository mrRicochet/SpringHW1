package ru.good.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.good.domain.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
}