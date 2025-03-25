package com.example.cstracker.Model;

import java.util.Random;
import java.security.InvalidParameterException;

public class Player {

    private Long id;
    private String nickname;
    private int idade;
    private String team;

   

    public Player(Long id, String nickname, int idade, String team) {      
        this.id = (id == null) ? Math.abs(new Random().nextLong()) : id;
        this.nickname = nickname;
        this.idade = idade;
        validateNickname(nickname);  
        validateIdade(idade); 
        this.team = team;
    }

    private void validateNickname(String nickname) {
        if (nickname == null || nickname.trim().isEmpty()) {
            throw new InvalidParameterException("Nickname não pode ser nulo ou vazio.");
        }
    }

    private void validateIdade(int idade) {
        if (idade < 0) {
            throw new InvalidParameterException("Idade não pode ser negativa.");
        }
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public int getIdade() {
        return idade;
    }

    public String getTeam() {
        return team;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Player [id=" + id + ", nickname=" + nickname + ", idade=" + idade + ", team=" + team + "]");
    }
}
