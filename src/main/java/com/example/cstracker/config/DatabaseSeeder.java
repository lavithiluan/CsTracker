package com.example.cstracker.config;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import com.example.cstracker.model.Estatistica;
import com.example.cstracker.model.Player;
import com.example.cstracker.repository.EstatisticaRepository;
import com.example.cstracker.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import jakarta.annotation.PostConstruct;

@Configuration
public class DatabaseSeeder {

    @Autowired
    private EstatisticaRepository estatisticaRepository;

    @Autowired
    private PlayerRepository playerRepository;

    private final Random random = new Random();

    @PostConstruct
    public void init() {

        // Criar jogadores
        var players = List.of(
                Player.builder().nickname("Fallen").time("Furia").sexo('M').dataNascimento(LocalDate.parse("2000-01-01")).build(),
                Player.builder().nickname("Fer").time("Imperial").sexo('M').dataNascimento(LocalDate.parse("1995-05-15")).build(),
                Player.builder().nickname("Coldzera").time("Red Canids").sexo('M').dataNascimento(LocalDate.parse("1998-10-20")).build(),
                Player.builder().nickname("Fnx").time("Last Dance").sexo('M').dataNascimento(LocalDate.parse("1992-03-30")).build(),
                Player.builder().nickname("Taco").time("Mibr").sexo('M').dataNascimento(LocalDate.parse("1990-07-25")).build()
        );

        // Salvar os jogadores primeiro (gera os IDs)
        playerRepository.saveAll(players);

        // Criar uma estatística por jogador
        for (Player player : players) {
            Estatistica estatistica = new Estatistica();
            estatistica.setPlayer(player);
            estatistica.setKills(random.nextInt(40));
            estatistica.setDeaths(random.nextInt(20));
            estatistica.setAssists(random.nextInt(15));
            estatistica.setHeadshots(random.nextInt(30));
            estatistica.setAccuracy(30 + random.nextDouble() * 70); // de 30.0 a 100.0

            estatisticaRepository.save(estatistica);
        }
    }
}
