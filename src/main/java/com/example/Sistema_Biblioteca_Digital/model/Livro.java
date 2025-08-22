package com.example.Sistema_Biblioteca_Digital.model;

import jakarta.persistence.*;

@Entity
@Table(name="livros")
public class Livro extends MediaItem {


    private int numeroPaginas;

    public Livro(){}

    public Livro(String authorOrPublisher, String titulo, int ano, int numeroPaginas) {
        super(authorOrPublisher, titulo, ano);
        this.numeroPaginas = numeroPaginas;
    }



    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
}
