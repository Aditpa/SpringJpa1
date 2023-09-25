package com.example.SpringDataJPA1Hibernate.controller;

import com.example.SpringDataJPA1Hibernate.model.School;
import com.example.SpringDataJPA1Hibernate.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SchoolController {
    @Autowired
    private SchoolRepository schoolRepository;

    @GetMapping("/school")
    public String getSchool(Model model, @RequestParam(required = false) Long id) {

        School school = new School();
        if (id != null) {
            Optional<School> optionalWizard = schoolRepository.findById(id);
            if (optionalWizard.isPresent()) {
                school = optionalWizard.get();
            }
        }
        model.addAttribute("school", school);
        return "school";
    }
    @GetMapping("/schools")
    public String getAll(Model model) {

        model.addAttribute("schools", schoolRepository.findAll());

        return "schools";
    }


    @PostMapping("/school")
    public String addingSchool(@ModelAttribute School school){

        schoolRepository.save(school);
        return "redirect:/schools";
    }

    @GetMapping("/school/delete")
    public String deleteWizard(@RequestParam Long id) {

        schoolRepository.deleteById(id);

        return "redirect:/schools";
    }
}
