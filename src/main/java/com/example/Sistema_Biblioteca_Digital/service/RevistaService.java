package com.example.Sistema_Biblioteca_Digital.service;

import com.example.Sistema_Biblioteca_Digital.model.Revista;
import com.example.Sistema_Biblioteca_Digital.repository.RevistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RevistaService {
    private final RevistaRepository revistaRepository;

    public RevistaService(RevistaRepository revistaRepository) {
        this.revistaRepository = revistaRepository;
    }

    public List<Revista> listarRevistas(){
        return  revistaRepository.findAll();
    }

    public Optional<Revista> buscarPorId(Long id){
        return revistaRepository.findById(id);
    }

    public Revista adicionarRevista(Revista revista){
        return revistaRepository.save(revista);
    }

    public boolean deletarRevistaPorId(Long id){
        if (revistaRepository.existsById(id)){
            revistaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
