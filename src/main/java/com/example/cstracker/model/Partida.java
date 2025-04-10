package com.example.cstracker.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;
    private String mapa;

    @OneToMany(mappedBy = "partida", cascade = CascadeType.ALL)
    private List<Statistics> statistics;

    
    // Construtor 
    public Partida(Long id, Date data, String mapa, List<Statistics> statistics) {
        this.id = id;
        this.data = data;
        this.mapa = mapa;
        this.statistics = statistics;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }

    // Override 
    @Override
    public String toString() {
        return "Partida{" +
                "id=" + id +
                ", data=" + data +
                ", mapa='" + mapa + '\'' +
                ", statistics=" + statistics +
                '}';
    }
}
