package com.example.cstracker.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;
    private String time;
    private char sexo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "player")
    private List<Statistics> statistics;

    public Player() {
    }

    // Construtor
    public Player(Long id, String nickname, String time, char sexo, LocalDate dataNascimento) {
        this.id = id;
        this.nickname = nickname;
        this.time = time;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Override 
    @Override
    public String toString() {
        return "Player [id=" + id +
                ", nickname=" + nickname +
                ", dataNascimento=" + dataNascimento +
                ", sexo=" + sexo +
                ", time=" + time +
                "]";
    }
}