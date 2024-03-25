package dev.micfro.weeklyquicklylight.controller;

import dev.micfro.weeklyquicklylight.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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


}
