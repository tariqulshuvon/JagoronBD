package com.therapJavaFest.jagoronBD.controller;

import com.therapJavaFest.jagoronBD.form.PoliceNumberForm;
import com.therapJavaFest.jagoronBD.model.PoliceNumber;
import com.therapJavaFest.jagoronBD.service.DivisionService;
import com.therapJavaFest.jagoronBD.service.PoliceNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/policeNumber")
public class PoliceNumberAddingController {

    @Autowired
    DivisionService divisionService;

    @Autowired
    PoliceNumberService numberService;



    @GetMapping("/new")
    public String showPoliceNumberAddingForm(Model model) {

        model.addAttribute("form", PoliceNumberForm.builder().build());
        model.addAttribute("divisionList",divisionService.findAll());

        return "police/form";
    }

    @PostMapping("/save")
    public String savePoliceNumber(@ModelAttribute("form") PoliceNumberForm numberForm, BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("divisionList", divisionService.findAll());
            return "police/form";
        }

        divisionService.findById(numberForm.getDivisionId()).ifPresent(division -> {
            numberService.save(PoliceNumber.builder()
                    .id(numberForm.getId())
                    .division(division)
                    .phoneNumberNo(numberForm.getPhoneNumberNo())
                    .name(numberForm.getName())
                    .phoneNumber(numberForm.getPhoneNumber())
                    .build());
        });

        return "redirect:/police";

    }


}
