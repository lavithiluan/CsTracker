package com.example.cstracker.model;

import java.time.LocalDate;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Player {

    private Long id;
    private String nickname;
    private String time;
    private char sexo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    public Player(Long id, String nickname, LocalDate dataNascimento, String time, char sexo) {
        this.id = (id == null) ? Math.abs(new Random().nextLong()) : id;
        this.nickname = nickname;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.time = time;
    }

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

    public LocalDate getdataNascimento() {
        return dataNascimento;
    }

    public void setdataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    @Override
    public String toString() {
        return "Player [id=" + id + 
                        ", nickname=" + nickname + 
                        ", dataNascimento=" + dataNascimento +
                        ", sexo=" + sexo +	
                        ", time=" + time
                + "]";
    }

}
