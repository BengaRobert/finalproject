package ro.sda.java30.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sda.java30.finalproject.model.ApplicationRole;
import ro.sda.java30.finalproject.model.CustomerDto;
import ro.sda.java30.finalproject.model.ProductDto;
import ro.sda.java30.finalproject.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/create")
    public String showCustomer(Model model) {
        model.addAttribute("formObject", new CustomerDto());
        return "/customer";
    }

    @PostMapping("/")
    public String saveAllCustomers(@ModelAttribute("formObject") CustomerDto form, Model model) {
        if(form.getApplicationRole()==null){
            form.setApplicationRole(ApplicationRole.ROLE_USER);
        }
        form = customerService.save(form);
        model.addAttribute("formObject", form);
        return "redirect:/customer/";
    }
    @GetMapping("/list")
    public String showAllCustomers(Model model) {
        model.addAttribute("customerList", customerService.getAllCustomers());
        return "customer_list";
    }

    @GetMapping("/update/{id}")
    public String updateCustomer(@PathVariable Long id, Model model) {
        CustomerDto customerDto = customerService.findProductById(id);
        model.addAttribute("formObject", customerDto);
        return "/customer";
    }
        @GetMapping("/delete/{id}")
        public String deleteCustomer(@PathVariable Long id, Model model) {
            customerService.deleteCustomer(id);
            return "redirect:/customer/list";
        }
    }



