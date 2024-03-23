package dev.micfro.weeklyquicklylight.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private boolean enabled;

    // Mapping
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authority_id")
    private Authority authority;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;


    // Constructors
    public User() {
    }


    public User(String username, String password, boolean enabled, Authority authority) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authority = authority;
    }

    public User(String username, String password, boolean enabled, Authority authority, Customer customer) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authority = authority;
        this.customer = customer;
    }

    // toString


    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
