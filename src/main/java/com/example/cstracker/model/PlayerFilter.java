package com.example.cstracker.model;

import java.time.LocalDate;

public record PlayerFilter(
        String nickname,
        String time,
        Character sexo,
        LocalDate nascimentoInicio,
        LocalDate nascimentoFim
) {}
