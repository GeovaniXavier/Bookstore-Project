package com.example.livraria.controller;

import com.example.livraria.dto.LivroDto;
import com.example.livraria.entity.Livro;
import com.example.livraria.mapper.LivroMapper;
import com.example.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {


    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroDto>> findAll() {
        return ResponseEntity.ok(LivroMapper.transformaListaLivroEmListaLivroDto(livroService.findAll()));
    }

    public ResponseEntity<LivroDto> save(Livro livro) {
        return ResponseEntity.ok(LivroMapper.TransformarEntidadeEmDto(livroService.save(livro)));
    }
}
