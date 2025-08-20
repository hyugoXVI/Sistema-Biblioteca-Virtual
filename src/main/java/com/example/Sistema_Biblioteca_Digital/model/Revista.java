package com.example.Sistema_Biblioteca_Digital.model;

import jakarta.persistence.*;

@Entity
@Table(name="revistas")
public class Revista extends MediaItem{


    private int numeroEdicao;

    public Revista(){}

    public Revista(String authorOrPublisher, String title, int year, int numeroEdicao) {
        super(authorOrPublisher, title, year);
        this.numeroEdicao = numeroEdicao;
    }



    public int getNumeroEdicao() {
        return numeroEdicao;
    }
}
