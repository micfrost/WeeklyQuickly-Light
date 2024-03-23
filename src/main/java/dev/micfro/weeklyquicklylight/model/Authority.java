package dev.micfro.weeklyquicklylight.model;

import jakarta.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String authority;


    // Mapping
    @OneToOne(mappedBy = "authority")
    private User user;


    // Constructors
    public Authority() {
    }

    public Authority(String authority) {
        this.authority = authority;
    }

    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
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

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
