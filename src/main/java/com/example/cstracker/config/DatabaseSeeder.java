package com.example.cstracker.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.cstracker.repository.EstatisticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.cstracker.model.Estatistica;
import com.example.cstracker.model.Player;
import com.example.cstracker.model.User;
import com.example.cstracker.model.UserRole;
import com.example.cstracker.repository.PlayerRepository;
import com.example.cstracker.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Configuration
public class DatabaseSeeder {


    @Autowired
    private EstatisticaRepository estatisticaRepository;
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Random random = new Random();

    @PostConstruct
    public void init() {
        var players = List.of(
                Player.builder().nickname("Fallen").time("Furia").sexo('M').dataNascimento(LocalDate.parse("2000-01-01")).build(),
                Player.builder().nickname("Fer").time("Imperial").sexo('M').dataNascimento(LocalDate.parse("1995-05-15")).build(),
                Player.builder().nickname("Coldzera").time("Red Canids").sexo('M').dataNascimento(LocalDate.parse("1998-10-20")).build(),
                Player.builder().nickname("Fnx").time("Last Dance").sexo('M').dataNascimento(LocalDate.parse("1992-03-30")).build(),
                Player.builder().nickname("Taco").time("Mibr").sexo('M').dataNascimento(LocalDate.parse("1990-07-25")).build()
        );

        var playersWithStats = new ArrayList<Player>();

        for (Player player : players) {
            var statsForPlayer = new ArrayList<Estatistica>();

            for (int i = 0; i < 10; i++) {
                Estatistica estatistica = new Estatistica();
                estatistica.setKills(random.nextInt(40));
                estatistica.setDeaths(random.nextInt(40));
                estatistica.setAssists(random.nextInt(25));
                estatistica.setHeadshots(random.nextInt(30));
                estatistica.setAccuracy(40 + (random.nextDouble() * 60));
                estatistica.setPlayer(player);
                statsForPlayer.add(estatistica);
            }

            player.setEstatisticas(statsForPlayer);
            playersWithStats.add(player);
        }

        playerRepository.saveAll(playersWithStats);
    }
}
