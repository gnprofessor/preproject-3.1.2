package ru.javamentor.preproject311.converters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import ru.javamentor.preproject311.model.Role;
import ru.javamentor.preproject311.service.RoleService;

import java.util.HashSet;
import java.util.Set;

@Service
public class StringArrayToRoleConverter implements Converter<String[], Set<Role>> {

    @Autowired
    private RoleService roleService;

    @Override
    public Set<Role> convert(String[] strings) {
        Set<Role> roleSet = new HashSet<>();
        for (String string : strings) {
            if (string.equals("ROLE_ADMIN")) {
                roleSet.add(roleService.findAll().get(0));
            }
            if (string.equals("ROLE_USER")) {
                roleSet.add(roleService.findAll().get(1));
            }
        }
        return roleSet;
    }
}
