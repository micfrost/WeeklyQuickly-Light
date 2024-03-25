package dev.micfro.weeklyquicklylight.controller;

import dev.micfro.weeklyquicklylight.model.Product;
import dev.micfro.weeklyquicklylight.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product-list")
    public String productList(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "product-list";
    }

    @GetMapping("/product-form")
    public String getProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/product-form")
    public String postProductForm(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/product-list";
    }
}


