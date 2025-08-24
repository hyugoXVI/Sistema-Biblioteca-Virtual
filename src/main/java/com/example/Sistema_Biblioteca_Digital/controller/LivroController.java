package com.example.Sistema_Biblioteca_Digital.controller;

import com.example.Sistema_Biblioteca_Digital.model.Livro;
import com.example.Sistema_Biblioteca_Digital.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livros")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> listarLivros(){
        return livroService.listarLivros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id){
        Optional<Livro> livroOptional = livroService.buscarLivroId(id);

        return livroOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Livro> adicionarLivro(@Valid @RequestBody Livro livro){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(livroService.adicionarLivro(livro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable long id, @Valid @RequestBody Livro livroAtualizado){
        Optional<Livro> livroOptional = livroService.atualizarLivroPorId(id, livroAtualizado);

        return livroOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivroPorId(@PathVariable Long id){
        if (livroService.deletarLivro(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
