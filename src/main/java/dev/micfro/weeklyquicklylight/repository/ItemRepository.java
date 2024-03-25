package dev.micfro.weeklyquicklylight.repository;

import dev.micfro.weeklyquicklylight.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
