package com.example.Sistema_Biblioteca_Digital.repository;


import com.example.Sistema_Biblioteca_Digital.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}