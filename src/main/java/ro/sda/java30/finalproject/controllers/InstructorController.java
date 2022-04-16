package ro.sda.java30.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.sda.java30.finalproject.model.InstructorDto;
import ro.sda.java30.finalproject.service.InstructorService;

import java.io.IOException;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }


    @GetMapping("/create")
    public String showInstructors(Model model) {
        model.addAttribute("formObject", new InstructorDto());
        return "instructor";
    }

    @PostMapping("/")
    public String saveAllInstructors(@RequestParam("file")MultipartFile file, @ModelAttribute("formObject") InstructorDto form, Model model) throws IOException {
        form.setPhoto(file.getBytes());
        form = instructorService.save(form);
        model.addAttribute("formObject", form);
        return "redirect:/instructor";
    }

    @GetMapping("")
    public String showAllInstructors(Model model) {
        model.addAttribute("instructorsList", instructorService.getAllInstructors());
        return "instructor_list";
    }

    @GetMapping("/update/{id}")
    public String updateInstructor(@PathVariable Long id, Model model) {
        InstructorDto instructorDto = instructorService.findInstructorById(id);
        model.addAttribute("formObject", instructorDto);
        return "instructor";
    }

    @GetMapping("/delete/{id}")
    public String deleteInstructor(@PathVariable Long id, Model model) {
        instructorService.deleleteInstructor(id);
        return "redirect:/instructor";
    }


}
