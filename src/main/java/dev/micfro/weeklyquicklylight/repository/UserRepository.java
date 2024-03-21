package dev.micfro.weeklyquicklylight.repository;

import dev.micfro.weeklyquicklylight.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
