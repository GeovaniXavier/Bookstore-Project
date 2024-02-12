package com.example.livraria.controller;

import com.example.livraria.dto.CategoriaDto;
import com.example.livraria.entity.Categoria;
import com.example.livraria.mapper.CategoriaMapper;
import com.example.livraria.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll() {
        List<Categoria> categorias = categoriaService.findAll();
        List<CategoriaDto> categoriasDto = new ArrayList<>();
        for (Categoria categoria : categorias) {
            categoriasDto.add(CategoriaMapper.transformaCategoriaEmCategoriaDto(categoria));
        }
        return ResponseEntity.ok().body(categoriasDto);
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> save(@RequestBody @Valid CategoriaDto categoriaDto) {
        Categoria categoria = CategoriaMapper.transformaCategoriaDtoEmCategoria(categoriaDto);
        Categoria categoriaSalva = categoriaService.save(categoria);
        CategoriaDto categoriaDtoSalva = CategoriaMapper.transformaCategoriaEmCategoriaDto(categoriaSalva);
        return ResponseEntity.ok().body(categoriaDtoSalva);
    }

}



