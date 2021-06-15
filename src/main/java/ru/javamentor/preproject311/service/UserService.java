package ru.javamentor.preproject311.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.javamentor.preproject311.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findUserByEmail(String email);
    List<User> findAll();
    User findById(long id);
    void saveUser(User user);
    void deleteUser(long id);
}
