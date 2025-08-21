package com.example.Sistema_Biblioteca_Digital.controller;

import com.example.Sistema_Biblioteca_Digital.model.Revista;
import com.example.Sistema_Biblioteca_Digital.service.RevistaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/revistas")
public class RevistaController {
    private final RevistaService revistaService;

    public RevistaController(RevistaService revistaService) {
        this.revistaService = revistaService;
    }

    @GetMapping
    public List<Revista> listarRevistas(){
        return revistaService.listarRevistas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Revista> buscarRevistaPorId(@PathVariable long id){
        Optional<Revista> revistaOptional = revistaService.buscarPorId(id);

        return revistaOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Revista> adicionarRevista(@RequestBody Revista revista){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(revistaService.adicionarRevista(revista));
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<Void> deletarRevistaPorId(@PathVariable Long id){
        if (revistaService.deletarRevistaPorId(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
