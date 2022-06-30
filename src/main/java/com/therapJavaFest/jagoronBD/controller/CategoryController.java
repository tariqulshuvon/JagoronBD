package com.therapJavaFest.jagoronBD.controller;


import com.therapJavaFest.jagoronBD.form.CategoryForm;
import com.therapJavaFest.jagoronBD.model.Category;
import com.therapJavaFest.jagoronBD.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/new")
    public String showCategoryForm (Model model) {
        model.addAttribute("form", CategoryForm.builder().build());
        return "category/form";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("saveCategory") CategoryForm form, BindingResult result) {
        if(form.getId() == null) {
            categoryService.findByName(form.getName()).ifPresent(name ->
                    result.rejectValue("name","error.form",form.getName() + "try a new Category"));
        }


        categoryService.save(Category.builder()
                        .id(form.getId())
                        .name(form.getName())
                .build());
        return "redirect:/";
    }




}
