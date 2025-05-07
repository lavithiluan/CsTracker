package com.example.cstracker.repository;

import com.example.cstracker.model.Player;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Page<Player> findByNicknameContainingIgnoreCase(String nickname, org.springframework.data.domain.Pageable pageable);

    Page<Player> findByDataNascimentoBetween(LocalDate start, LocalDate end, org.springframework.data.domain.Pageable pageable);

    Page<Player> findAll(Specification<Player> spec, Pageable pageable);
}
