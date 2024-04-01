package dev.micfro.weeklyquicklylight.service;

import dev.micfro.weeklyquicklylight.model.Product;
import dev.micfro.weeklyquicklylight.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }


    // init Data
    @PostConstruct
    public void initProducts() {
        Product dallmayrProdomo500g = createProduct("Dallmayr Prodomo 500g", 4.99);
        Product cocaCola1l = createProduct("Coca Cola 1l", 0.99);


        dallmayrProdomo500g.addItem();
        dallmayrProdomo500g.addItem();
        cocaCola1l.addItems(5L);

        saveProduct(dallmayrProdomo500g);
        saveProduct(cocaCola1l);
    }


    // CRUD

    // CREATE
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Product createProduct(String productName, double priceRetail) {
        Product product = new Product(productName, BigDecimal.valueOf(priceRetail));
        return productRepository.save(product);
    }


    // READ
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }


    public Product findProductByName(String productName) {
        return productRepository.findByName(productName);
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product findProductById(Integer id) {
        return productRepository.findById(Long.valueOf(id)).orElse(null);
    }


    // UPDATE

    // DELETE


}
