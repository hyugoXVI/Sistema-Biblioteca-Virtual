package com.example.Sistema_Biblioteca_Digital.service;

import com.example.Sistema_Biblioteca_Digital.model.Livro;
import com.example.Sistema_Biblioteca_Digital.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAllByOrderByIdAsc();
    }

    public Optional<Livro> buscarLivroId(Long id) {

        return livroRepository.findById(id);

    }

    public Livro adicionarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Optional<Livro> atualizarLivroPorId(long id, Livro livroAtualizado) {
        Optional<Livro> livroOptional = livroRepository.findById(id);

        if (livroOptional.isPresent()) {
            Livro livroBuscado = livroOptional.get();

            livroBuscado.setAuthorOrPublisher(livroAtualizado.getAuthorOrPublisher());
            livroBuscado.setTitulo(livroAtualizado.getTitulo());
            livroBuscado.setAno(livroAtualizado.getAno());
            livroBuscado.setNumeroPaginas(livroAtualizado.getNumeroPaginas());

            return Optional.of(livroRepository.save(livroBuscado));
        }
        return Optional.empty();
    }


    public boolean deletarLivro(Long id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
