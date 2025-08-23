package com.example.Sistema_Biblioteca_Digital.repository;

import com.example.Sistema_Biblioteca_Digital.model.Revista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RevistaRepository extends JpaRepository<Revista, Long> {
    List<Revista> findAllByOrderByIdAsc();
}
