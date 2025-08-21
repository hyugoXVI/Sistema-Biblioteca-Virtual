package com.example.Sistema_Biblioteca_Digital.controller;

import com.example.Sistema_Biblioteca_Digital.model.ArtigoCientifico;
import com.example.Sistema_Biblioteca_Digital.service.ArtigoCientificoService;
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

    @GetMapping("{/id}")
    public ResponseEntity<ArtigoCientifico> buscarArtigoPorId(@PathVariable long id){
        Optional<ArtigoCientifico> artigoCientificoOptional = artigoCientificoService.buscarArtigoPorId(id);

        return artigoCientificoOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ArtigoCientifico> criarArtigo(@RequestBody ArtigoCientifico artigoCientifico){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(artigoCientificoService.adicionarArtigo(artigoCientifico));
    }
}
