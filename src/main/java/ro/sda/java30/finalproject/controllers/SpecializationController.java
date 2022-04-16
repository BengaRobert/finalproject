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
        model.addAttribute("formObject",new SpecializationDto());
        return "specialization";
    }
    @PostMapping("/")
    public String saveAllSpecializations(@ModelAttribute("formObject") SpecializationDto from, Model model){
        from = specializationService.save(from);
        model.addAttribute("formObject", from);
        return "redirect:/specialization";
    }
    @GetMapping("")
    public String showAllSpecializations(Model model){
        model.addAttribute("specializationList", specializationService.getAllSpecializations());
        return "specialization_list";
    }

    @GetMapping("/update/{id}")
    public String updateSpecialization(@PathVariable Long id, Model model){
        SpecializationDto specializationDto = specializationService.findSpecializationById(id);
        model.addAttribute("formObject", specializationDto);
        return "/specialization";
    }

    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable Long id, Model model){
        specializationService.deleteSpecialization(id);
        return"redirect:/specialization";
    }


}
