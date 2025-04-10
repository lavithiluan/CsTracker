package com.example.cstracker.model;

import jakarta.persistence.*;

@Entity
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "partida_id")
    private Partida partida;

    private int kills;
    private int deaths;
    private int assists;
    private int headshots;
    private double accuracy;

    // Construtor
    public Statistics(Long id, Player player, Partida partida, int kills, int deaths, int assists, int headshots,
            double accuracy) {
        this.id = id;
        this.player = player;
        this.partida = partida;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.headshots = headshots;
        this.accuracy = accuracy;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getHeadshots() {
        return headshots;
    }

    public void setHeadshots(int headshots) {
        this.headshots = headshots;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    // Override 
    @Override
    public String toString() {
        return "Statistics{" + 
                "id=" + id + 
                ", player=" + player.getNickname() + 
                ", partida=" + partida.getMapa() + 
                ", kills=" + kills + 
                ", deaths=" + deaths + 
                ", assists=" + assists + 
                ", headshots=" + headshots + 
                ", accuracy=" + accuracy + 
                '}';
    }
    
}
