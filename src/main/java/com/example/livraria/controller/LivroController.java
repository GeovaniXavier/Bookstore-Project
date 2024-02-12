package com.example.livraria.controller;

import com.example.livraria.dto.LivroDto;
import com.example.livraria.entity.Livro;
import com.example.livraria.mapper.LivroMapper;
import com.example.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<List<LivroDto>> findAll() {
        List<LivroDto> dtos = new ArrayList<>();
        List<Livro> livros = livroService.findAll();
        for (Livro livro : livros) {
            dtos.add(LivroMapper.transformarEntidadeEmDto(livro));
        }
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<LivroDto> save(@RequestBody Livro livro) {
        Livro savedLivro = livroService.save(livro);
        LivroDto livroDto = LivroMapper.transformarEntidadeEmDto(savedLivro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroDto);
    }
}
