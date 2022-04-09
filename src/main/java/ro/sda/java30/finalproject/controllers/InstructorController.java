package ro.sda.java30.finalproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ro.sda.java30.finalproject.entities.Instructors;
import ro.sda.java30.finalproject.repository.InstructorRepository;

@Controller
public class InstructorController {

    @Autowired
    private final InstructorRepository instructorRepository;

    public InstructorController(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    @GetMapping("/instructor")
    public String showInstructors(Model model){
        model.addAttribute("formObject", new Instructors());
       return "instructor";
    }

    @PostMapping("/instructor")
    public String saveAllInstructors(@ModelAttribute("formObject") Instructors form, Model model){
        instructorRepository.save(form);
        return "instructor";
    }


}
