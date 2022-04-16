package ro.sda.java30.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sda.java30.finalproject.model.SpecializationDto;
import ro.sda.java30.finalproject.service.SpecializationService;

@Controller
@RequestMapping("/specialization")
public class SpecializationController {
    private final SpecializationService specializationService;

    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;

    }

    @GetMapping("/create")
    public String showServices(Model model){
        model.addAttribute("fromObject",new SpecializationDto());
        return "specialization";
    }
    @PostMapping("/")
    public String saveAllSpecializations(@ModelAttribute("fromObject") SpecializationDto from, Model model){
        from = specializationService.save(from);
        model.addAttribute("fromObject", from);
        return "redirect:/specialization";
    }
    @GetMapping("")
    public String showAllSpecializations(Model model){
        model.addAttribute("specializationsList", specializationService.getAllSpecializations());
        return "specialization";
    }

    @GetMapping("/update/{id}")
    public String updateSpecialization(@PathVariable Long id, Model model){
        SpecializationDto specializationDto = specializationService.findSpecializationById(id);
        return "specialization";
    }

    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable Long id, Model model){
        specializationService.deleteSpecialization(id);
        return"redirect:/specialization";
    }


}
