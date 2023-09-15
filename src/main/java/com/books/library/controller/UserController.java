package com.books.library.controller;

import com.books.library.entity.User;
import com.books.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userList")
    public String showAllUsers(Model model) {
        try {
            List<User> users = userService.getAllUsers();
            model.addAttribute("frontendUsers", users);
            return "users";
        } catch (Exception e) {
            return "Error. " + e.getMessage();
        }
    }

    @GetMapping("/newUser")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping("/newUser")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/newUser";
    }

    @PostMapping("/editUser")
    public String editUser(@ModelAttribute User user) {
        userService.editUserById(user.getId(), user);
        return "redirect:/userList";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam long id) {
        userService.deleteUserById(id);
        return "redirect:/userList";
    }

}
