package com.example.cstracker.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.cstracker.Model.Player;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private Logger log = LoggerFactory.getLogger(getClass());
    private List<Player> repository = new ArrayList<>();

    @GetMapping("/all")
    public List<Player> index() {
        return repository;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Player> create(@RequestBody Player player) {
        log.info("Cadastrando jogador: {}", player.getNickname());
        repository.add(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(player);
    }

    @GetMapping("/{id}")
    public Player get(@PathVariable Long id) {
        log.info("Buscando jogador com ID {}", id);
        return getPlayer(id);
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("Apagando jogador com ID {}", id);
        repository.remove(getPlayer(id));
    }

    @PutMapping("/atualizar/{id}")
    public Player update(@PathVariable Long id, @RequestBody Player player) {
        log.info("Atualizando jogador com ID {} e dados {}", id, player);
        repository.remove(getPlayer(id));
        player.setId(id);
        repository.add(player);
        return player;
    }

    private Player getPlayer(Long id) {
        return repository
            .stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogador não encontrado."));
    }
}