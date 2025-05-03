package com.example.cstracker.repository;
import java.util.Optional;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.example.cstracker.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
 
    Optional<User> findByEmail(String username);
 
}