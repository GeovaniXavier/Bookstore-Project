package com.example.livraria.controller;

import com.example.livraria.dto.AutorDto;
import com.example.livraria.entity.Autor;
import com.example.livraria.mapper.AutorMapper;
import com.example.livraria.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {


    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<AutorDto>> findAll() {
        List<Autor> autores = autorService.findAll();
        List<AutorDto> autoresDto = AutorMapper.transformaListaAutorEmListaAutorDto(autores);
        return ResponseEntity.ok().body(autoresDto);
    }

    @PostMapping
    public ResponseEntity<AutorDto> save(@RequestBody @Valid AutorDto autorDto) {
        Autor autor = AutorMapper.transformaAutorDtoEmAutor(autorDto);
        Autor autorSalvo = autorService.save(autor);
        AutorDto autorDtoSalvo = AutorMapper.transformaAutorEmAutorDto(autorSalvo);
        return ResponseEntity.ok().body(autorDtoSalvo);
    }
}
