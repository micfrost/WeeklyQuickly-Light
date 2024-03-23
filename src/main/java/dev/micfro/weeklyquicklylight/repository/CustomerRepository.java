package dev.micfro.weeklyquicklylight.repository;

import dev.micfro.weeklyquicklylight.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
