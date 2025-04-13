package com.example.cstracker.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Estatistica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player")
    @JsonBackReference
    private Player player;

    private int kills;
    private int deaths;
    private int assists;
    private int headshots;
    private double accuracy;
}