package com.example.cstracker.config;

import com.example.cstracker.model.Partida;
import com.example.cstracker.model.Player;
import com.example.cstracker.model.Statistics;
import com.example.cstracker.repository.PartidaRepository;
import com.example.cstracker.repository.PlayerRepository;
import com.example.cstracker.repository.StatisticsRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Configuration
public class DatabaseSeeder {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private StatisticsRepository statisticsRepository;

    @PostConstruct
    public void init() {
        // Cadastra jogadores
        var players = List.of(
                new Player(null, "ZywOo", "Vitality", 'M', LocalDate.of(2000, 11, 9)),
                new Player(null, "s1mple", "NAVI", 'M', LocalDate.of(1997, 10, 2))
        );
        playerRepository.saveAll(players);

        // Cadastra partida
        var partida = new Partida(null, new Date(), "Mirage", null);
        partida.setData(new Date());
        partida.setMapa("Mirage");
        partidaRepository.save(partida);

        // Cadastra estatísticas
        var stat1 = new Statistics(null, players.get(0), partida, 25, 10, 5, 10, 0.65);
        var stat2 = new Statistics(null, players.get(1), partida, 30, 12, 4, 15, 0.70);
        statisticsRepository.saveAll(List.of(stat1, stat2));
    }
}
