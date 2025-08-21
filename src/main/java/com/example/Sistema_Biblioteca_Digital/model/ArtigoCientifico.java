package com.example.Sistema_Biblioteca_Digital.model;

import jakarta.persistence.*;

@Entity
@Table(name="artigos")
public class ArtigoCientifico extends MediaItem {


    private String conferenciaPublicacao;

    public ArtigoCientifico(){}

    public ArtigoCientifico(String authorOrPublisher, String titulo, int ano, String conferenciaPublicacao) {
        super(authorOrPublisher, titulo, ano);
        this.conferenciaPublicacao = conferenciaPublicacao;
    }



    public String getConferenciaPublicacao() {
        return conferenciaPublicacao;
    }
}
