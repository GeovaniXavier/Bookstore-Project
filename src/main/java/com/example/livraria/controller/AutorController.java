package com.example.livraria.controller;

import com.example.livraria.entity.Autor;
import com.example.livraria.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autor")
public class AutorController {


    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(autorService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid Autor autor) {
        return ResponseEntity.ok().body(autorService.save(autor));
    }
}
