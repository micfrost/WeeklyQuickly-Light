package dev.micfro.weeklyquicklylight.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class CartPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ManyToOne with Cart - Bidirectional
    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;


    private Integer quantityOrdered;

    private BigDecimal priceOrdered;


    // Constructors
    public CartPosition() {
    }

    public CartPosition(Cart cart, Product product, BigDecimal priceOrdered) {
        this.cart = cart;
        this.product = product;
        this.quantityOrdered = 1;
        this.priceOrdered = priceOrdered;
    }


    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getOrder() {
        return cart;
    }

    public void setOrder(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public BigDecimal getPriceOrdered() {
        return priceOrdered;
    }

    public void setPriceOrdered(BigDecimal priceOrdered) {
        this.priceOrdered = priceOrdered;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
