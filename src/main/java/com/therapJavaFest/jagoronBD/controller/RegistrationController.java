package com.therapJavaFest.jagoronBD.controller;


import com.therapJavaFest.jagoronBD.form.UserRegistrationForm;
import com.therapJavaFest.jagoronBD.model.User;
import com.therapJavaFest.jagoronBD.model.UserRole;
import com.therapJavaFest.jagoronBD.service.RoleService;
import com.therapJavaFest.jagoronBD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", UserRegistrationForm.builder().build());
        return "users/form";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") UserRegistrationForm form) {

        User user = User.builder()
                .username(form.getUsername())
                .password(form.getPassword())
                .roles(List.of(roleService.findById(UserRole.USER.getId())))
                .build();
        userService.save(user);
        return "redirect:/login";
    }


    @PostMapping("/admin")
    public String saveAdmin(@ModelAttribute("admin") UserRegistrationForm form, Model model) {
        User user = null;

        if (form.getId() != null) {
            user = userService.findById(form.getId()).orElse(null);
            if (user != null) {
                user.setUsername(form.getUsername());
                userService.save(user);
            }
        } else {
            user = User.builder()
                    .username(form.getUsername())
                    .password(form.getPassword())
                    .roles(List.of(roleService.findById(UserRole.ADMIN.getId())))
                    .build();
            userService.save(user);
        }

        return "redirect:/admins";

    }

}
