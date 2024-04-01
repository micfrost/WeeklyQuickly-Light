package dev.micfro.weeklyquicklylight.controller;

import dev.micfro.weeklyquicklylight.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
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
