package com.example.Sistema_Biblioteca_Digital.model;

import jakarta.persistence.*;

@Entity
@Table(name="artigos")
public class ArtigoCientifico extends MediaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String conferenciaPublicacao;

    public ArtigoCientifico(){}

    public ArtigoCientifico(String authorOrPublisher, String title, int year, String conferenciaPublicacao) {
        super(authorOrPublisher, title, year);
        this.conferenciaPublicacao = conferenciaPublicacao;
    }

    public long getId() {
        return id;
    }

    public String getConferenciaPublicacao() {
        return conferenciaPublicacao;
    }
}
