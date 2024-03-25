package dev.micfro.weeklyquicklylight.controller;

import dev.micfro.weeklyquicklylight.model.Item;
import dev.micfro.weeklyquicklylight.model.Product;
import dev.micfro.weeklyquicklylight.service.ItemService;
import dev.micfro.weeklyquicklylight.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {
    
    ItemService itemService;
    ProductService productService;

    @Autowired
    public ItemController(ItemService itemService, ProductService productService) {
        this.itemService = itemService;
        this.productService = productService;
    }

    @GetMapping("/item-list")
    public String itemList(Model model) {
        model.addAttribute("items", itemService.findAllItems());
        return "item-list";
    }

    @GetMapping("/item-form")
    public String getItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "item-form";
    }

    @PostMapping("/item-form")
    public String postItemForm(@ModelAttribute("item") Item item) {
        // if name product of this item already exists, then add the quantity to the existing product
        String nameOfProduct = item.getProduct().getName();


        if (itemService.findItemByNameOfProduct(nameOfProduct) != null) {
            Product existingProduct = itemService.findItemByNameOfProduct(nameOfProduct).getProduct();
                    existingProduct.addItems(item.getQuantity());
            productService.saveProduct(existingProduct);
            return "redirect:/item-list";
        }





        // if product of this item does not exist, then create a new product

        itemService.saveItem(item);
        return "redirect:/item-list";
    }
    
    
    
    
    
    
    
    
    
    
    
}
