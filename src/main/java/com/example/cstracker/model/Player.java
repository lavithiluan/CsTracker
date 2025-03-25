package com.example.cstracker.Model;

import java.util.Random;

public class Player {

    private Long id;
    private String nickname;
    private int idade;
    private String team;
    



    public Player(Long id, String nickname, int idade, String team) {
        this.id = (id == null) ? Math.abs(new Random().nextLong()) : id;
        this.nickname = (nickname);
        this.idade = (idade);
        this.team = (team);
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
