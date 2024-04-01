package dev.micfro.weeklyquicklylight.service;

import dev.micfro.weeklyquicklylight.model.Cart;
import dev.micfro.weeklyquicklylight.model.Customer;
import dev.micfro.weeklyquicklylight.repository.CartRepository;
import dev.micfro.weeklyquicklylight.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public CartService(CartRepository cartRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }

    // CRUD

    // CREATE

    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }


    // READ

    public Cart findCartById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    public Cart findCartById(Integer id) {
        return cartRepository.findById(Long.valueOf(id)).orElse(null);
    }

    // find all carts
    public List<Cart> findAllCarts() {
        return cartRepository.findAll();
    }

    // UPDATE

    // DELETE


}
