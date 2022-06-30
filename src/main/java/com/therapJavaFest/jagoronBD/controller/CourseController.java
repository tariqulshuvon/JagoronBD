package com.therapJavaFest.jagoronBD.controller;

import com.therapJavaFest.jagoronBD.model.Item;
import com.therapJavaFest.jagoronBD.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    ItemService itemService;

    @GetMapping
    public String showCourses(Model model) {

        List<Item> courseList = itemService.findAllByCategoryId(6L);
        model.addAttribute("courseList",courseList);

        return "course/list";
    }


}
