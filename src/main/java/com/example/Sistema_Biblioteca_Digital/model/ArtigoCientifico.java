package com.example.Sistema_Biblioteca_Digital.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="artigos")
public class ArtigoCientifico extends MediaItem {

    @NotBlank(message = "O local da conferêcia não pode ficar em branco.")
    private String conferenciaPublicacao;

    public ArtigoCientifico(){}

    public ArtigoCientifico(String authorOrPublisher, String titulo, int ano, String conferenciaPublicacao) {
        super(authorOrPublisher, titulo, ano);
        this.conferenciaPublicacao = conferenciaPublicacao;
    }

    public void setConferenciaPublicacao(String conferenciaPublicacao) {
        this.conferenciaPublicacao = conferenciaPublicacao;
    }

    public String getConferenciaPublicacao() {
        return conferenciaPublicacao;
    }
}
