package com.example.cstracker.Controller;

import com.example.cstracker.model.Statistics;
import com.example.cstracker.repository.StatisticsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/estatisticas")
public class StatisticsController {

    @Autowired
    StatisticsRepository repository;

    @GetMapping
    public List<Statistics> listar() {
        return repository.findAll();
    }

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public Statistics cadastrar(@RequestBody Statistics stats) {
        return repository.save(stats);
    }

    @GetMapping("/{id}")
    public Statistics buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estatística não encontrada"));
    }

    @PutMapping("/atualizar/{id}")
    public Statistics atualizar(@PathVariable Long id, @RequestBody Statistics stats) {
        buscarPorId(id);
        stats.setId(id);
        return repository.save(stats);
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        Statistics stats = buscarPorId(id);
        repository.delete(stats);
    }
}
