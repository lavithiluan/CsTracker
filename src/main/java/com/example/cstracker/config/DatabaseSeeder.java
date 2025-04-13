package com.example.cstracker.config;

import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.cstracker.model.Player;
import com.example.cstracker.repository.PlayerRepository;
import jakarta.annotation.PostConstruct;

@Configuration
public class DatabaseSeeder {

    @Autowired
    private PlayerRepository playerRepository;

    @PostConstruct
    public void init() {
        var player = List.of(
            Player.builder().nickname("Player 1").time("Time A").sexo('M').dataNascimento(LocalDate.parse("2000-01-01")).build(),
            Player.builder().nickname("Player 2").time("Time B").sexo('F').dataNascimento(LocalDate.parse("1995-05-15")).build(),
            Player.builder().nickname("Player 3").time("Time C").sexo('M').dataNascimento(LocalDate.parse("1998-10-20")).build(),
            Player.builder().nickname("Player 4").time("Time D").sexo('F').dataNascimento(LocalDate.parse("1992-03-30")).build(),
            Player.builder().nickname("Player 5").time("Time E").sexo('M').dataNascimento(LocalDate.parse("1990-07-25")).build());
        
        playerRepository.saveAll(player);
    }
}
