package com.example.Sistema_Biblioteca_Digital.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class MediaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String authorOrPublisher;
    private  String titulo;
    private  int ano;


    public MediaItem(){}

    public MediaItem(String authorOrPublisher, String titulo, int ano) {
        this.authorOrPublisher = authorOrPublisher;
        this.titulo = titulo;
        this.ano = ano;
    }

    public String getAuthorOrPublisher() {
        return authorOrPublisher;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public long getId() {
        return id;
    }
}
