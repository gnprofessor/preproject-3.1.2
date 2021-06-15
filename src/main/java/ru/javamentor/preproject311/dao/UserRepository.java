package ru.javamentor.preproject311.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javamentor.preproject311.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
