package com.example.Sistema_Biblioteca_Digital.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.time.Year;

@Entity
@Table(name="livros")
public class Livro extends MediaItem {

    @Positive(message = "O número de páginas tende a ser postivo.")
    private int numeroPaginas;

    public Livro(){}

    public Livro(String authorOrPublisher, String titulo, Year ano, int numeroPaginas) {
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
