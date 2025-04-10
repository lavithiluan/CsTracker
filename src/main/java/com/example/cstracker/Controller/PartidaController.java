package com.example.cstracker.Controller;

import com.example.cstracker.model.Partida;
import com.example.cstracker.repository.PartidaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    @Autowired
    PartidaRepository repository;

    @GetMapping
    public List<Partida> listar() {
        return repository.findAll();
    }

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public Partida cadastrar(@RequestBody Partida partida) {
        return repository.save(partida);
    }

    @GetMapping("/{id}")
    public Partida buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partida não encontrada"));
    }

    @PutMapping("/atualizar/{id}")
    public Partida atualizar(@PathVariable Long id, @RequestBody Partida partida) {
        buscarPorId(id);
        partida.setId(id);
        return repository.save(partida);
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        Partida partida = buscarPorId(id);
        repository.delete(partida);
    }
}
