package dev.micfro.weeklyquicklylight.service;

import dev.micfro.weeklyquicklylight.model.Cart;
import dev.micfro.weeklyquicklylight.model.CartPosition;
import dev.micfro.weeklyquicklylight.model.Product;
import dev.micfro.weeklyquicklylight.repository.CartPositionRepository;
import dev.micfro.weeklyquicklylight.repository.CartRepository;
import dev.micfro.weeklyquicklylight.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartPositionService {

    private final CartPositionRepository cartPositionRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    public CartPositionService(CartPositionRepository cartPositionRepository, CartRepository cartRepository, ProductRepository productRepository) {
        this.cartPositionRepository = cartPositionRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }



    // CRUD

    // CREATE

    public void saveCartPosition(CartPosition cartPosition) {
        cartPositionRepository.save(cartPosition);
    }

    // READ

    public CartPosition findCartPositionById(Long id) {
        return cartPositionRepository.findById(id).orElse(null);
    }

    public CartPosition findCartPositionById(Integer id) {
        return cartPositionRepository.findById(Long.valueOf(id)).orElse(null);
    }

    // find all cartPositions
    public List<CartPosition> findAllCartPositions() {
        return cartPositionRepository.findAll();
    }

    // UPDATE


    // DELETE

}
