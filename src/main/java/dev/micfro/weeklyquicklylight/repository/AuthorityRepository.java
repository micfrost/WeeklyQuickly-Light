package dev.micfro.weeklyquicklylight.repository;

import dev.micfro.weeklyquicklylight.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
