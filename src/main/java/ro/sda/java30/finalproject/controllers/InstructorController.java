package ro.sda.java30.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.java30.finalproject.model.InstructorDto;
import ro.sda.java30.finalproject.service.InstructorService;

@Controller
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }


    @GetMapping("/instructor/create")
    public String showInstructors(Model model) {
        model.addAttribute("formObject", new InstructorDto());
        return "instructor";
    }

    @PostMapping("/instructor")
    public String saveAllInstructors(@ModelAttribute("formObject") InstructorDto form, Model model) {
        form = instructorService.save(form);
        model.addAttribute("formObject", form);
        return "redirect:/instructorsList";
    }
    @GetMapping("/instructorsList")
    public String showAllInstructors(Model model) {
        model.addAttribute("instructorsList", instructorService.getAllInstructors());
        return "instructor_list";
    }
    @GetMapping("/instructor/update/{id}")
    public String updateInstructor(@PathVariable Long id, Model model){
        InstructorDto instructorDto = instructorService.findInstructorById(id);
        model.addAttribute("formObject", instructorDto);
        return "instructor";
    }


}
