package dev.micfro.weeklyquicklylight.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // OneToMany relationship with an Item
    @OneToMany(mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Item> items;


    private Long quantity;


    // Methods

    public Long calculateTotalQuantity() {
        return items.stream().mapToLong(Item::getQuantity).sum();
    }

    // Method
    public void addItem() {
        if (items == null) {
            items = new ArrayList<>();
        }

        items.add(new Item(this));
        quantity = calculateTotalQuantity();


    }

    public void addItems(Long itemQuantity) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        items.add(new Item(this, itemQuantity));
        quantity = calculateTotalQuantity();
    }

    // Constructors
    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }
// Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getQuantity() {
        quantity = calculateTotalQuantity();
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
