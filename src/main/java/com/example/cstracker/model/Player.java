package com.example.cstracker;

import java.util.Random;

public class Player {
    private Long id;
    private String nickname;
    private int age;
    private String team;

    public Player(Long id, String nickname, int age, String team) {
        this.id = (id == null) ? Math.abs(new Random().nextLong()) : id;
        this.nickname = nickname;
        this.age = age;
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public String getTeam() {
        return team;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Player [id=" + id + ", nickname=" + nickname + ", age=" + age + ", team=" + team + "]";
    }
}
