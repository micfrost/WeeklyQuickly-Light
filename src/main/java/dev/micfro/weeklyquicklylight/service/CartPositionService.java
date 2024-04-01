package dev.micfro.weeklyquicklylight.service;

import dev.micfro.weeklyquicklylight.model.CartPosition;
import dev.micfro.weeklyquicklylight.repository.CartPositionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartPositionService {

    private final CartPositionRepository cartPositionRepository;

    @Autowired
    public CartPositionService(CartPositionRepository cartPositionRepository) {
        this.cartPositionRepository = cartPositionRepository;
    }

  

    // CRUD

    // CREATE

    public void saveCartPosition(CartPosition cartPosition) {
        cartPositionRepository.save(cartPosition);
    }

    public CartPosition createCartPosition() {
        CartPosition cartPosition = new CartPosition();
        return cartPositionRepository.save(cartPosition);
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
