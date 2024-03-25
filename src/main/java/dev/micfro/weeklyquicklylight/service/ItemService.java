package dev.micfro.weeklyquicklylight.service;

import dev.micfro.weeklyquicklylight.model.Item;
import dev.micfro.weeklyquicklylight.model.Product;
import dev.micfro.weeklyquicklylight.repository.ItemRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ProductService productService;

    @Autowired
    public ItemService(ItemRepository itemRepository, ProductService productService) {
        this.itemRepository = itemRepository;
        this.productService = productService;
    }



    // CRUD

    // CREATE
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public Item createItem(Product product) {
        Item item = new Item(product);

        return itemRepository.save(item);
    }


    // READ

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // UPDATE

    // DELETE


}
