package com.example.cstracker.repository;

import com.example.cstracker.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {   
}