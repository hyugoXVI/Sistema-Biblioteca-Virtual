package com.example.Sistema_Biblioteca_Digital.service;

import com.example.Sistema_Biblioteca_Digital.model.ArtigoCientifico;
import com.example.Sistema_Biblioteca_Digital.repository.ArtigoCientificoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtigoCientificoService {
    private final ArtigoCientificoRepository artigoCientificoRepository;

    public ArtigoCientificoService(ArtigoCientificoRepository artigoCientificoRepository) {
        this.artigoCientificoRepository = artigoCientificoRepository;
    }

    public List<ArtigoCientifico> listarArtigos(){
        return artigoCientificoRepository.findAll();
    }

    public Optional<ArtigoCientifico> buscarArtigoPorId(Long id){
        return artigoCientificoRepository.findById(id);
    }

    public ArtigoCientifico adicionarArtigo(ArtigoCientifico artigo){
        return artigoCientificoRepository.save(artigo);
    }

    public void deletarArtigoPorId(Long id){
        artigoCientificoRepository.deleteById(id);
    }
}
