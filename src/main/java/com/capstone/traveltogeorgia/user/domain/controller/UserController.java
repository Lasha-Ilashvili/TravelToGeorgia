package com.capstone.traveltogeorgia.user.domain.controller;

import com.capstone.traveltogeorgia.user.data.service.UserService;
import com.capstone.traveltogeorgia.user.domain.model.Role;
import com.capstone.traveltogeorgia.user.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String showUserProfile(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.findByUsername(principal.getName());

            if (user.getRole() == Role.ADMIN) {
                return "redirect:/admin";
            }

            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
        }

        return "profile";
    }

    @GetMapping("/admin")
    public String adminDashboard(Model model, Principal principal) {
        model.addAttribute("users", userService.getAllUsersExceptCurrent(principal.getName()));

        return "admin_dashboard";
    }
}