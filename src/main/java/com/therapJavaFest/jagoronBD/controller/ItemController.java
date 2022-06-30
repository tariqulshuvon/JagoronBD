package com.therapJavaFest.jagoronBD.controller;


import com.therapJavaFest.jagoronBD.form.ItemForm;
import com.therapJavaFest.jagoronBD.model.Item;
import com.therapJavaFest.jagoronBD.service.CategoryService;
import com.therapJavaFest.jagoronBD.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {


    @Autowired
    ItemService itemService;
    @Autowired
    CategoryService categoryService;



    @GetMapping
    public String showItems(Model model) {
        List<Item> items =itemService.findAll();
        model.addAttribute("items",items);

        return "item/list";
    }



    @GetMapping("/new")
    public String showNewItemAddingForm(Model model) {
        model.addAttribute("form", ItemForm.builder().build());
        model.addAttribute("categoryList", categoryService.findAll());

        return "item/form";
    }

    @PostMapping("/save")
    public String saveNewItem(@Valid @ModelAttribute("form") ItemForm form, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("categoryList", categoryService.findAll());
            return "item/form";
        }

            categoryService.findById(form.getCategoryId()).ifPresent(category -> {
                itemService.save(Item.builder()
                        .id(form.getId())
                        .category(category)
                        .logo(form.getLogo())
                        .image(form.getImage())
                        .name(form.getName())
                        .description(form.getDescription())
                        .link(form.getLink())
                        .build());
            });


        return "redirect:/item";
    }

    @GetMapping("/edit/{id}")
    public String editItem(Model model, @PathVariable(name = "id") Long id) {

        itemService.findById(id).ifPresent(form-> {
            ItemForm itemForm = ItemForm.builder()
                    .id(form.getId())
                    .categoryId(form.getCategory().getId())
                    .logo(form.getLogo())
                    .image(form.getImage())
                    .name(form.getName())
                    .description(form.getDescription())
                    .link(form.getLink())
                    .build();

            model.addAttribute("form", itemForm);
            model.addAttribute("categoryList", categoryService.findAll());
        });

        return "item/form";
    }

    @RequestMapping("/delete/{id}")
    public String deleteItem(Model model, @PathVariable(name = "id") Long id) {

        itemService.delete(id);

        return "redirect:/item";
    }

}
