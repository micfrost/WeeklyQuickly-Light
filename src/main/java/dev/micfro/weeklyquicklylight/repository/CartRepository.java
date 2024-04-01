package dev.micfro.weeklyquicklylight.repository;

import dev.micfro.weeklyquicklylight.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
