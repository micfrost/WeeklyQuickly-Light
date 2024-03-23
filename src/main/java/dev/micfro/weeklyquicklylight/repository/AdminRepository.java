package dev.micfro.weeklyquicklylight.repository;

import dev.micfro.weeklyquicklylight.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
