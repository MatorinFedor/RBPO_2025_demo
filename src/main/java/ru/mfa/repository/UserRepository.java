package ru.mfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mfa.entity.ApplicationUser;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<ApplicationUser, UUID> {
    Optional<ApplicationUser> findByEmail(String email);
}
