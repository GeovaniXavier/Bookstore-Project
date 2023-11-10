package com.example.livraria.mapper;

import com.example.livraria.dto.CategoriaDto;
import com.example.livraria.entity.Categoria;

import java.util.List;

public class CategoriaMapper {


    public static Categoria transformaCategoriaDtoEmCategoria(CategoriaDto dto) {
        Categoria categoria = new Categoria();
        categoria.setId(dto.getId());
        categoria.setNome(dto.getNome());
        return categoria;
    }

    public static CategoriaDto transformaCategoriaEmCategoriaDto(Categoria categoria) {
        CategoriaDto dto = new CategoriaDto();
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());
        return dto;
    }

    public static List<Categoria> transformaListaCategoriaDtoEmListaCategoria(List<CategoriaDto> dtos) {
        List<Categoria> categorias = null;
        for (CategoriaDto dto : dtos) {
            categorias.add(transformaCategoriaDtoEmCategoria(dto));
        }
        return categorias;
    }

    public static List<CategoriaDto> transformaListaCategoriaEmListaCategoriaDto(List<Categoria> categorias) {
        List<CategoriaDto> dtos = null;
        for (Categoria categoria : categorias) {
            dtos.add(transformaCategoriaEmCategoriaDto(categoria));
        }
        return dtos;
    }

}
