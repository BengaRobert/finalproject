package ro.sda.java30.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sda.java30.finalproject.model.EquipmentDto;
import ro.sda.java30.finalproject.model.ProductDto;
import ro.sda.java30.finalproject.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/create")
    public String showProduct(Model model) {
        model.addAttribute("formObject", new ProductDto());
        return "/product";
    }

    @PostMapping("/")
    public String saveAllProducts(@ModelAttribute("formObject") ProductDto form, Model model) {
        form = productService.save(form);
        model.addAttribute("formObject", form);
        return "redirect:/product/";
    }

    @GetMapping("")
    public String showAllProducts(Model model) {
        model.addAttribute("productList", productService.getAllProducts());
        return "product_list";
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, Model model) {
        ProductDto productDto = productService.findProductById(id);
        model.addAttribute("formObject", productDto);
        return "/product";
    }

    @GetMapping("/delete")
    public String deleteProduct(@PathVariable Long id, Model model) {
        productService.deleteProduct(id);
        return "redirect:/product";
    }
}
