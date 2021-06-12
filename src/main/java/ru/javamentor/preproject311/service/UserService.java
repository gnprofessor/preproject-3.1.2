package ru.javamentor.preproject311.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.javamentor.preproject311.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findUserByUserName(String name);
    List<User> findAll();
    User findById(long id);
    void saveUser(User user);
    void deleteUser(long id);
}
