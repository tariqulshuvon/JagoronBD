package com.therapJavaFest.jagoronBD.controller;


import com.therapJavaFest.jagoronBD.model.User;
import com.therapJavaFest.jagoronBD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String showUsers(Model model) {

        List<User> users = userService.findAll();
        model.addAttribute("users",users);

        return "users/list";
    }

}
