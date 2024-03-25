package dev.micfro.weeklyquicklylight.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantity;

    private LocalDate dateAddedToStorage;

    // ManyToOne relationship with a Product
    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;


    // Constructors

    public Item() {
        dateAddedToStorage = LocalDate.now();
    }


    public Item(Product product) {
        dateAddedToStorage = LocalDate.now();
        quantity = 1L;
        this.product = product;
    }

    public Item(Product product, Long quantity) {
        dateAddedToStorage = LocalDate.now();
        this.quantity = quantity;
        this.product = product;
    }
// Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return dateAddedToStorage;
    }

    public void setDate(LocalDate date) {
        this.dateAddedToStorage = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}
