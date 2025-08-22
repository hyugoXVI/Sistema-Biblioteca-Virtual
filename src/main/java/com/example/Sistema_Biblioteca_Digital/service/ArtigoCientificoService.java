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

    public Optional<ArtigoCientifico> atualizarArtigoPorId(long id, ArtigoCientifico artigoCientificoAtualizado){
        Optional<ArtigoCientifico> artigoOptional = artigoCientificoRepository.findById(id);

        if (artigoOptional.isPresent()){
            ArtigoCientifico artigoCientificoBuscado = artigoOptional.get();

            artigoCientificoBuscado.setAuthorOrPublisher(artigoCientificoAtualizado.getAuthorOrPublisher());
            artigoCientificoBuscado.setTitulo(artigoCientificoAtualizado.getTitulo());
            artigoCientificoBuscado.setAno(artigoCientificoAtualizado.getAno());
            artigoCientificoBuscado.setConferenciaPublicacao(artigoCientificoAtualizado.getConferenciaPublicacao());

            return Optional.of(artigoCientificoRepository.save(artigoCientificoBuscado));
        }
        return Optional.empty();
    }

    public boolean deletarArtigoPorId(Long id){
        if (artigoCientificoRepository.existsById(id)){
            artigoCientificoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
