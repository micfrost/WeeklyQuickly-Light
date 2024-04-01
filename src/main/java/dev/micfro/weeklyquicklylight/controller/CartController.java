package dev.micfro.weeklyquicklylight.controller;

import dev.micfro.weeklyquicklylight.model.Cart;
import dev.micfro.weeklyquicklylight.service.CartPositionService;
import dev.micfro.weeklyquicklylight.service.CartService;
import dev.micfro.weeklyquicklylight.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    private final ProductService productService;
    private final CartPositionService cartPositionService;
    private final CartService cartService;


    @Autowired
    public CartController(ProductService productService, CartPositionService cartPositionService, CartService cartService) {
        this.productService = productService;
        this.cartPositionService = cartPositionService;
        this.cartService = cartService;

    }

    // CRUD

    // READ
    @GetMapping("/cart-list")
    public String cartList(Model model) {
        model.addAttribute("carts", cartService.findAllCarts());
        return "cart-list";
    }


    // CREATE



    // UPDATE

    // DELETE


}
