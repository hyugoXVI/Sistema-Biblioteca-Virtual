package com.example.Sistema_Biblioteca_Digital.service;

import com.example.Sistema_Biblioteca_Digital.model.Livro;
import com.example.Sistema_Biblioteca_Digital.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarLivros(){
        return  livroRepository.findAll();
    }

    public Optional<Livro> buscarLivroId(Long id){

        return livroRepository.findById(id);

    }

    public Livro adicionarLivro(Livro livro){
        return livroRepository.save(livro);
    }

    public boolean deletarLivro(Long id){
        if (livroRepository.existsById(id)){
            livroRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
