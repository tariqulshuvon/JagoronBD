package com.therapJavaFest.jagoronBD.controller;


import com.therapJavaFest.jagoronBD.form.CategoryForm;
import com.therapJavaFest.jagoronBD.form.DivisionForm;
import com.therapJavaFest.jagoronBD.model.Category;
import com.therapJavaFest.jagoronBD.model.Division;
import com.therapJavaFest.jagoronBD.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/division")
public class DivisionController {

    @Autowired
    DivisionService divisionService;

    @GetMapping("/new")
    public String showDivisionForm (Model model) {
        model.addAttribute("form", DivisionForm.builder().build());
        return "division/form";
    }

    @PostMapping("/save")
    public String saveDivision(@ModelAttribute("form") DivisionForm form, BindingResult result) {
        if(form.getId() == null) {
            divisionService.findByName(form.getName()).ifPresent(name ->
                    result.rejectValue("name","error.form",form.getName() + "try a new Division"));
        }


        divisionService.save(Division.builder()
                        .id(form.getId())
                        .name(form.getName())
                .build());
        return "redirect:/division/new";
    }




}
