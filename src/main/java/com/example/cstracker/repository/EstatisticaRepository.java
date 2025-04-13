package com.example.cstracker.repository;

import com.example.cstracker.model.Estatistica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstatisticaRepository extends JpaRepository<Estatistica, Long> {
}