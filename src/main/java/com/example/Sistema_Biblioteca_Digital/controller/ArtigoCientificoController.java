package com.example.Sistema_Biblioteca_Digital.controller;

import com.example.Sistema_Biblioteca_Digital.model.ArtigoCientifico;
import com.example.Sistema_Biblioteca_Digital.repository.ArtigoCientificoRepository;
import com.example.Sistema_Biblioteca_Digital.service.ArtigoCientificoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artigos")
public class ArtigoCientificoController {
    private final ArtigoCientificoService artigoCientificoService;


    public ArtigoCientificoController(ArtigoCientificoService artigoCientificoService) {
        this.artigoCientificoService = artigoCientificoService;
    }

    @GetMapping
    public List<ArtigoCientifico> listarArtigos(){
        return artigoCientificoService.listarArtigos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtigoCientifico> buscarArtigoPorId(@PathVariable long id){
        Optional<ArtigoCientifico> artigoCientificoOptional = artigoCientificoService.buscarArtigoPorId(id);

        return artigoCientificoOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ArtigoCientifico> criarArtigo(@Valid @RequestBody ArtigoCientifico artigoCientifico){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(artigoCientificoService.adicionarArtigo(artigoCientifico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtigoCientifico> atualizarArtigoPorId(@PathVariable long id,
                                                                 @Valid  @RequestBody ArtigoCientifico
                                                                         artigoCientificoAtualizado){
        Optional<ArtigoCientifico> artigoCientificoOptional = artigoCientificoService
                .atualizarArtigoPorId(id, artigoCientificoAtualizado);

        return  artigoCientificoOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ArtigoCientifico> deletarArtigoPorId(long id){
        if (artigoCientificoService.deletarArtigoPorId(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
