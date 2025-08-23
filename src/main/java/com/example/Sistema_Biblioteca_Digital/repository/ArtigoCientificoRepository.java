package com.example.Sistema_Biblioteca_Digital.repository;

import com.example.Sistema_Biblioteca_Digital.model.ArtigoCientifico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtigoCientificoRepository extends JpaRepository<ArtigoCientifico, Long> {
    List<ArtigoCientifico> findAllByOrderByIdAsc();
}
