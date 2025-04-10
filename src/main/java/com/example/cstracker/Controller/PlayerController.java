package com.example.cstracker.Controller;

import com.example.cstracker.model.Player;
import com.example.cstracker.repository.PlayerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class PlayerController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    PlayerRepository repository;

    @GetMapping("/all")
    public List<Player> index() {
        return repository.findAll();
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Player> create(@RequestBody Player player) {
        log.info("Cadastrando jogador: {}", player.getNickname());
        Player savedPlayer = repository.save(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlayer);
    }

    @GetMapping("/{id}")
    public Player findPlayerById(@PathVariable Long id) {
        log.info("Buscando jogador com ID {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogador não encontrado"));
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("Apagando jogador com ID {}", id);
        repository.delete(findPlayerById(id));
    }

    @PutMapping("/atualizar/{id}")
    public Player update(@PathVariable Long id, @RequestBody Player player) {
        log.info("Atualizando jogador com ID {}", id);
        player.setId(id);
        return repository.save(player);
    }
}