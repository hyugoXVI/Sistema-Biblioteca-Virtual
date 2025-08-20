package com.example.Sistema_Biblioteca_Digital.model;

import jakarta.persistence.*;

@Entity
@Table(name="livros")
public class Livro extends MediaItem {


    private int numeroPaginas;

    public Livro(){}

    public Livro(String authorOrPublisher, String title, int year, int numeroPaginas) {
        super(authorOrPublisher, title, year);
        this.numeroPaginas = numeroPaginas;
    }



    public int getNumeroPaginas() {
        return numeroPaginas;
    }
}
