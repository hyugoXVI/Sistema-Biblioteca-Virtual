package com.example.Sistema_Biblioteca_Digital.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="livros")
public class Livro extends MediaItem {

    @Positive(message = "O número de páginas tende a ser postivo.")
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
