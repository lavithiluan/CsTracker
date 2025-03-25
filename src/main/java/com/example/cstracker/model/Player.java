package com.example.cstracker.Model;

import java.security.InvalidParameterException;

public class Player {

    private Long id;  
    private String nickname;
    private int idade;
    private String team;

    
    public Player(Long id, String nickname, int idade, String team) {  
        this.id = id; 
        validateNickname(nickname);  
        validateIdade(idade); 
        this.nickname = nickname;
        this.idade = idade;
        this.team = team;
    }

    public Player() {}

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

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        validateNickname(nickname);  
        this.nickname = nickname;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        validateIdade(idade);  
        this.idade = idade;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return String.format("Player [id=" + id + ", nickname=" + nickname + ", idade=" + idade + ", team=" + team + "]");
    }
}
