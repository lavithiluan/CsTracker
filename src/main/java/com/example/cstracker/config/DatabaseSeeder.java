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
        var p1 = new Player(null, "ZywOo", "Vitality", 'M', LocalDate.of(2000, 11, 9));
        var p2 = new Player(null, "s1mple", "NAVI", 'M', LocalDate.of(1997, 10, 2));

        playerRepository.saveAll(List.of(p1, p2));

        var partida = new Partida();
        partida.setData(new Date());
        partida.setMapa("Mirage");

        partidaRepository.save(partida);

        var stat1 = new Statistics();
        stat1.setPartida(partida);
        stat1.setPlayer(p1);
        stat1.setKills(25);
        stat1.setDeaths(10);
        stat1.setAssists(5);
        stat1.setHeadshots(10);
        stat1.setAccuracy(0.65);

        var stat2 = new Statistics();
        stat2.setPartida(partida);
        stat2.setPlayer(p2);
        stat2.setKills(30);
        stat2.setDeaths(12);
        stat2.setAssists(4);
        stat2.setHeadshots(15);
        stat2.setAccuracy(0.70);

        statisticsRepository.saveAll(List.of(stat1, stat2));
    }
}
