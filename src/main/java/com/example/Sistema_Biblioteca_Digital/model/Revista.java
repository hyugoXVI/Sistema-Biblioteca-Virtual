package com.example.Sistema_Biblioteca_Digital.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.time.Year;

@Entity
@Table(name="revistas")
public class Revista extends MediaItem{

    @Positive(message = "O número da edição tende a ser positivo.")
    private int numeroEdicao;

    public Revista(){}

    public Revista(String authorOrPublisher, String titulo, Year ano, int numeroEdicao) {
        super(authorOrPublisher, titulo, ano);
        this.numeroEdicao = numeroEdicao;
    }



    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public void setNumeroEdicao(int numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }
}
