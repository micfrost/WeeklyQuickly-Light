package dev.micfro.weeklyquicklylight.repository;

import dev.micfro.weeklyquicklylight.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
    Product findByName(String productName);
}
