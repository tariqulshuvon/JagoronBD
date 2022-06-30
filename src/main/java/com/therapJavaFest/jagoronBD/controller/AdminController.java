package com.therapJavaFest.jagoronBD.controller;


import com.therapJavaFest.jagoronBD.form.UserRegistrationForm;
import com.therapJavaFest.jagoronBD.model.Item;
import com.therapJavaFest.jagoronBD.model.User;
import com.therapJavaFest.jagoronBD.service.ItemService;
import com.therapJavaFest.jagoronBD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    UserService userService;


    @GetMapping
    public String showAdmins(Authentication authentication, Model model) {

        List<User> admins = userService.findAll();

        model.addAttribute("admins",admins);

        return "admins/list";
    }

    @GetMapping("/new")
    public String showCreate(Model model) {
        model.addAttribute("admins", UserRegistrationForm.builder().build());
        return "admins/form";
    }


    @GetMapping("/edit/{id}")
    public String editBookForm(Model model, @PathVariable(name = "id") long id) {
        userService.findById(id).ifPresent(form-> {
            UserRegistrationForm userRegistrationForm = UserRegistrationForm.builder()
                    .id(form.getId())
                    .username(form.getUsername())
                    .build();
            model.addAttribute("admins",userRegistrationForm);
        });
        return "admins/form";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") long id) {
        userService.delete(id);
        return "redirect:/admins";
    }


}
