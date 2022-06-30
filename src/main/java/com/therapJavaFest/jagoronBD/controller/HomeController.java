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
@RequestMapping("/")
public class HomeController {

    @Autowired
    ItemService itemService;

    @GetMapping
    public String home(Model model) {
        List<Item> productList = itemService.findAllByCategoryId(3L);
        model.addAttribute("productList", productList);

        List<Item> bookList = itemService.findAllByCategoryId(1L);
        model.addAttribute("bookList", bookList);

        List<Item> tutorialList = itemService.findAllByCategoryId(4L);
        model.addAttribute("tutorialList", tutorialList);

        List<Item> courseList = itemService.findAllByCategoryId(6L);
        model.addAttribute("courseList", courseList);


        return "index";
    }
}
