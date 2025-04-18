package com.example.cstracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.cstracker.model.Estatistica;
import com.example.cstracker.model.Player;
import com.example.cstracker.repository.EstatisticaRepository;
import com.example.cstracker.repository.PlayerRepository;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private EstatisticaRepository estatisticaRepository;

    // Cadastrar um jogador com suas estatísticas
    @PostMapping("/cadastro")
    @CacheEvict(value = "players", allEntries = true)
    public ResponseEntity<Player> cadastrarPlayer(@RequestBody Player player) {
        playerRepository.save(player);

        player.getEstatisticas().forEach(estatistica -> {
            estatistica.setPlayer(player);
            estatisticaRepository.save(estatistica);
        });

        return ResponseEntity.status(HttpStatus.CREATED).body(player);
    }

    // Obter todos os jogadores
    @GetMapping("/all")
    public List<Player> listarPlayers() {
        return playerRepository.findAll();
    }

    // Obter um jogador específico e suas estatísticas
    @GetMapping("/{id}")
    public ResponseEntity<Player> obterPlayer(@PathVariable Long id) {
        return playerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Obter as estatísticas de um jogador específico
    @GetMapping("/{id}/estatisticas")
    public ResponseEntity<List<Estatistica>> obterEstatisticas(@PathVariable Long id) {
        Player player = playerRepository.findById(id).orElse(null);
        if (player != null) {
            return ResponseEntity.ok(player.getEstatisticas());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Atualizar informações de um jogador
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza as informações de um jogador")
    public ResponseEntity<Player> atualizarPlayer(@PathVariable Long id, @RequestBody Player playerAtualizado) {
        return playerRepository.findById(id)
                .map(player -> {
                    player.setNickname(playerAtualizado.getNickname());
                    player.setSexo(playerAtualizado.getSexo());
                    player.setTime(playerAtualizado.getTime());
                    player.setDataNascimento(playerAtualizado.getDataNascimento());
                    playerRepository.save(player);
                    return ResponseEntity.ok(player);
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Atualizar estatísticas de um jogador
    @PutMapping("/estatisticas/{id}")
    public ResponseEntity<Estatistica> atualizarEstatisticas(@PathVariable Long id,
            @RequestBody Estatistica estatisticaAtualizada) {
        return estatisticaRepository.findById(id)
                .map(estatistica -> {
                    estatistica.setKills(estatisticaAtualizada.getKills());
                    estatistica.setDeaths(estatisticaAtualizada.getDeaths());
                    estatistica.setAssists(estatisticaAtualizada.getAssists());
                    estatistica.setHeadshots(estatisticaAtualizada.getHeadshots());
                    estatistica.setAccuracy(estatisticaAtualizada.getAccuracy());
                    estatisticaRepository.save(estatistica);
                    return ResponseEntity.ok(estatistica);
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Deletar um jogador e suas estatísticas
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPlayer(@PathVariable Long id) {
        return playerRepository.findById(id)
                .map(player -> {
                    estatisticaRepository.deleteAll(player.getEstatisticas());
                    playerRepository.delete(player);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}