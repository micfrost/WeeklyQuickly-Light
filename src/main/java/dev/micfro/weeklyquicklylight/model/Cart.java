package dev.micfro.weeklyquicklylight.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "cart", cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private Customer customer;


    @OneToMany(mappedBy = "cart",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<CartPosition> cartPositions;


    // Methods

    // addOrderLine
    public void addCartPosition(Product product) {
        if (cartPositions == null) {
            cartPositions = new ArrayList<>();
        }

        cartPositions.add(new CartPosition(
                this,
                product,
                product.getPriceRetail()
        ));
    }


    // Constructors
    public Cart() {
    }


    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CartPosition> getOrderLines() {
        return cartPositions;
    }

    public void setOrderLines(List<CartPosition> cartPositions) {
        this.cartPositions = cartPositions;
    }

    public List<CartPosition> getCartPositions() {
        return cartPositions;
    }

    public void setCartPositions(List<CartPosition> cartPositions) {
        this.cartPositions = cartPositions;
    }
}
