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

    @NotBlank(message = "O campo data é obrigatório")
    private int kills;

    @NotBlank(message = "O campo data é obrigatório")
    private int deaths;

    @NotBlank(message =" O campo data é obrigatório")
    private int assists;

    @NotBlank(message = "O campo data é obrigatório")
    private int headshots;

    @NotBlank(message = "O campo data é obrigatório")
    private double accuracy;
}