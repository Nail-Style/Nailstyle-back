package com.example.AgendaNailstyle.models;

import jakarta.persistence.*;

@Entity
@Table(name="tbagenda")

public class Agenda {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgenda;

    private int mesAgenda;
    private int diaAgenda;
    private String horarioAgenda;

    //Metodos Getters and Setters

    public Long getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Long idAgenda) {
        this.idAgenda = idAgenda;
    }

    public int getMesAgenda() {
        return mesAgenda;
    }

    public void setMesAgenda(int mesAgenda) {
        this.mesAgenda = mesAgenda;
    }

    public int getDiaAgenda() {
        return diaAgenda;
    }

    public void setDiaAgenda(int diaAgenda) {
        this.diaAgenda = diaAgenda;
    }

    public String getHorarioAgenda() {
        return horarioAgenda;
    }

    public void setHorarioAgenda(String horarioAgenda) {
        this.horarioAgenda = horarioAgenda;
    }
}
