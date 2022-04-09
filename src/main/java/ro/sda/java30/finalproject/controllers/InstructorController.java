package ro.sda.java30.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.sda.java30.finalproject.config.entities.Instructors;

@Controller
public class InstructorController {

    public InstructorController() {
    }
    @GetMapping("/instructor")
    public String showInstructors(Model model){
        model.addAttribute("formObject", new Instructors());
       return "instructor";
    }
}
