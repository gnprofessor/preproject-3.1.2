package ru.javamentor.preproject311.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.preproject311.converters.StringArrayToRoleConverter;
import ru.javamentor.preproject311.model.User;
import ru.javamentor.preproject311.service.RoleService;
import ru.javamentor.preproject311.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private StringArrayToRoleConverter roleConverter;

    @GetMapping()
    public String index(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", userService.findById(id));
        return "userId";
    }

    @GetMapping("/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.findAll());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user, @RequestParam(value = "roless", required = false) String[] roles) {
        user.setRoles(roleConverter.convert(roles));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("allRoles", roleService.findAll());
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @RequestParam(value = "roless", required = false) String[] roles) {
        user.setRoles(roleConverter.convert(roles));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
