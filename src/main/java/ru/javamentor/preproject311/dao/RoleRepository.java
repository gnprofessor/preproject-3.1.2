package ru.javamentor.preproject311.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javamentor.preproject311.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
