package dev.micfro.weeklyquicklylight.repository;

import dev.micfro.weeklyquicklylight.model.CartPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartPositionRepository extends JpaRepository<CartPosition, Long> {
}
