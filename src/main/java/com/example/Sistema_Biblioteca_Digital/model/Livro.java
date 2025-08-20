package com.example.Sistema_Biblioteca_Digital.model;

import jakarta.persistence.*;

@Entity
@Table(name="livros")
public class Livro extends MediaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int numeroPaginas;

    public Livro(){}

    public Livro(String authorOrPublisher, String title, int year, int numeroPaginas) {
        super(authorOrPublisher, title, year);
        this.numeroPaginas = numeroPaginas;
    }

    public long getId() {
        return id;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }
}
