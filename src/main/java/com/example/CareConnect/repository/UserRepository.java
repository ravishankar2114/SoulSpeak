package com.example.CareConnect.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository<User> extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}


