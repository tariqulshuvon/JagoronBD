package com.therapJavaFest.jagoronBD.controller;//package com.example.users.controller;
//
//
//import com.example.users.form.UserRegistrationForm;
//import com.example.users.model.User;
//import com.example.users.model.UserRole;
//import com.example.users.service.RoleService;
//import com.example.users.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/saveNewAdmin")
//public class AdminRegistrationController {
//
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private RoleService roleService;
//
//
//    @PostMapping
//    public String saveUser(@ModelAttribute("user") UserRegistrationForm form, Model model) {
//        User user = User.builder()
//                .username(form.getUsername())
//                .password(form.getPassword())
//                .roles(List.of(roleService.findById(UserRole.ADMIN.getId())))
//                .build();
//        userService.save(user);
//
//        return "redirect:/";
//    }
//
//}
