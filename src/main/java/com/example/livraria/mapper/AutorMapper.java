package com.example.livraria.mapper;

import com.example.livraria.dto.AutorDto;
import com.example.livraria.entity.Autor;

import java.util.List;

public class AutorMapper {


    public static AutorDto transformaAutorEmAutorDto(Autor autor) {
        AutorDto dto = new AutorDto();
        dto.setId(autor.getId());
        dto.setInstante(autor.getInstante());
        dto.setEmail(autor.getEmail());
        dto.setNome(autor.getNome());
        dto.setDescricao(autor.getDescricao());
        return dto;
    }

    public static Autor transformaAutorDtoEmAutor(AutorDto dto) {
        Autor autor = new Autor();
        autor.setId(dto.getId());
        autor.setInstante(dto.getInstante());
        autor.setEmail(dto.getEmail());
        autor.setNome(dto.getNome());
        autor.setDescricao(dto.getDescricao());
        return autor;
    }

    public static List<AutorDto> transformaListaAutorEmListaAutorDto(List<Autor> autores) {
        List<AutorDto> dtos = null;
        for (Autor autor : autores) {
            dtos.add(transformaAutorEmAutorDto(autor));
        }
        return dtos;
    }

    public static List<Autor> transformaListaAutorDtoEmListaAutor(List<AutorDto> dtos) {
        List<Autor> autores = null;
        for (AutorDto dto : dtos) {
            autores.add(transformaAutorDtoEmAutor(dto));
        }
        return autores;
    }

}
