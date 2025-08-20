package com.example.Sistema_Biblioteca_Digital.model;

import jakarta.persistence.*;

@Entity
@Table(name="revistas")
public class Revista extends MediaItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int numeroEdicao;

    public Revista(){}

    public Revista(String authorOrPublisher, String title, int year, int numeroEdicao) {
        super(authorOrPublisher, title, year);
        this.numeroEdicao = numeroEdicao;
    }

    public long getId() {
        return id;
    }

    public int getNumeroEdicao() {
        return numeroEdicao;
    }
}
