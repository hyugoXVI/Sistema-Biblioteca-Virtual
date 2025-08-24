package com.example.Sistema_Biblioteca_Digital.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

@MappedSuperclass
public class MediaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @NotBlank(message = "Autor/editor não pode ficar em branco.")
    private String authorOrPublisher;

    @NotBlank(message = "Título não pode ficar em branco.")
    private  String titulo;

    @NotNull(message = "O ano não pode ser nulo.")
//    @PastOrPresent(message = "O ano não pode ser maior que o ano atual.")
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

    public void setAuthorOrPublisher(String authorOrPublisher) {
        this.authorOrPublisher = authorOrPublisher;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
