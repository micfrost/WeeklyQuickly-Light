package dev.micfro.weeklyquicklylight.service;

import dev.micfro.weeklyquicklylight.model.Item;
import dev.micfro.weeklyquicklylight.model.Product;
import dev.micfro.weeklyquicklylight.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ItemService itemService;

    @Autowired
    public ProductService(ProductRepository productRepository, @Lazy ItemService itemService) {
        this.productRepository = productRepository;
        this.itemService = itemService;
    }


    // init Data
    @PostConstruct

    public void initProducts() {
        Product iphone = createProduct("Iphone");
        Product audi = createProduct("Audi");


        iphone.addItem();
        iphone.addItem();
        audi.addItems(5L);

        saveProduct(iphone);
        saveProduct(audi);
    }


    // CRUD

    // CREATE
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Product createProduct(String productName) {
        Product product = new Product(productName);
        return productRepository.save(product);
    }


    // READ
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }


    public Product getProductByName(String productName) {
        return productRepository.findByName(productName);
    }


    // UPDATE

    // DELETE


}
