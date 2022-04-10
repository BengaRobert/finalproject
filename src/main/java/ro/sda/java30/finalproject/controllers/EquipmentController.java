package ro.sda.java30.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sda.java30.finalproject.model.EquipmentDto;
import ro.sda.java30.finalproject.model.InstructorDto;
import ro.sda.java30.finalproject.service.EquipmentService;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/create")
    public String showEquipment(Model model) {
        model.addAttribute("formObject", new EquipmentDto());
        return "equipment";
    }

    @PostMapping("/")
    public String saveAllEquipment(@ModelAttribute("formObject") EquipmentDto form, Model model) {
        form = equipmentService.save(form);
        model.addAttribute("formObject", form);
        return "redirect:/equipment";
    }

    @GetMapping("")
    public String showAllEquipment(Model model) {
        model.addAttribute("equipmentList", equipmentService.getAllEquipment());
        return "equipment_list";
    }

    @GetMapping("/update/{id}")
    public String updateEquipment(@PathVariable Long id, Model model) {
        EquipmentDto equipmentDto = equipmentService.findEquipmentById(id);
        model.addAttribute("formObject", equipmentDto);
        return "/equipment";
    }

    @GetMapping("/delete/{id}")
    public String deleteEquipment(@PathVariable Long id, Model model) {
        equipmentService.deleteEquipment(id);
        return "redirect:/equipment";
    }
}
