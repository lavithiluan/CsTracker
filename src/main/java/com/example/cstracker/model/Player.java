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


    public Player(Long id, String nickname, String time, char sexo, LocalDate dataNascimento) {
        this.id = id;
        this.nickname = nickname;
        this.time = time;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }


    public String getNickname() {
        return nickname;
    }


    public String getTime() {
        return time;
    }


    public char getSexo() {
        return sexo;
    }


    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
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
                        ", time=" + time + 
                        "]";
    }

}
