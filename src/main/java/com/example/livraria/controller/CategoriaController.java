package com.example.livraria.controller;

import com.example.livraria.entity.Categoria;
import com.example.livraria.service.CategoriaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        return ResponseEntity.ok().body(categoriaService.findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Categoria> save(@RequestBody @Valid Categoria categoria) {
        return ResponseEntity.ok().body(categoriaService.save(categoria));
    }
}



