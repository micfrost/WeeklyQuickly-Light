package dev.micfro.weeklyquicklylight.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal priceRetail;

    // OneToMany Bidirectional
    @OneToMany(mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<>();

    private Long quantityAvailable;


@OneToMany(mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
private List<CartPosition> cartPositions;



    // Methods

    public Long calculateTotalQuantityAvailable() {
        return items.stream().mapToLong(Item::getQuantity).sum();
    }

    // Method
    public void addItem() {
        if (items == null) {
            items = new ArrayList<>();
        }

        items.add(new Item(this));
        quantityAvailable = calculateTotalQuantityAvailable();


    }

    public void addItems(Long itemQuantityAvailable) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        items.add(new Item(this, itemQuantityAvailable));
        quantityAvailable = calculateTotalQuantityAvailable();
    }

    // Constructors
    public Product() {
    }


    public Product(String name, BigDecimal priceRetail) {
        this.name = name;
        this.priceRetail = priceRetail;
        this.quantityAvailable = 1L;
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

    public Long getQuantityAvailable() {
        quantityAvailable = calculateTotalQuantityAvailable();
        return quantityAvailable;
    }

    public void setQuantityAvailable(Long quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public BigDecimal getPriceRetail() {
        return priceRetail;
    }

    public void setPriceRetail(BigDecimal priceRetail) {
        this.priceRetail = priceRetail;
    }

}
