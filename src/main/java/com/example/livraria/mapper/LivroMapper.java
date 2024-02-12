package com.example.livraria.mapper;

import com.example.livraria.dto.LivroDto;
import com.example.livraria.entity.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroMapper {

    public static LivroDto transformarEntidadeEmDto(Livro livro) {
        LivroDto livroDto = new LivroDto();
        livroDto.setId(livro.getId());
        livroDto.setTitulo(livro.getTitulo());
        livroDto.setResumo(livro.getResumo());
        livroDto.setSumario(livro.getSumario());
        livroDto.setPreco(livro.getPreco());
        livroDto.setNumeroPaginas(livro.getNumeroPaginas());
        livroDto.setIsbn(livro.getIsbn());
        livroDto.setDataPublicacao(livro.getDataPublicacao());
        livroDto.setAutorId(livro.getAutor().getId());
        livroDto.setCategoriaId(livro.getCategoria().getId());
        return livroDto;
    }

    public static Livro transformarDtoEmEntidade(LivroDto livroDto) {
        Livro livro = new Livro();
        livro.setId(livroDto.getId());
        livro.setTitulo(livroDto.getTitulo());
        livro.setResumo(livroDto.getResumo());
        livro.setSumario(livroDto.getSumario());
        livro.setPreco(livroDto.getPreco());
        livro.setNumeroPaginas(livroDto.getNumeroPaginas());
        livro.setIsbn(livroDto.getIsbn());
        livro.setDataPublicacao(livroDto.getDataPublicacao());

        return livro;
    }

    public static List<LivroDto> transformarListaLivroEmListaLivroDto(List<Livro> all) {
        return all.stream()
                .map(LivroMapper::transformarEntidadeEmDto)
                .collect(Collectors.toList());
    }
}
