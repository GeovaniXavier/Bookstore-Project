package com.example.livraria.mapper;

import com.example.livraria.dto.LivroDto;
import com.example.livraria.entity.Livro;

import java.util.List;

public class LivroMapper {


    public static LivroDto TransformarEntidadeEmDto(Livro livro) {
        LivroDto livroDto = new LivroDto();
        livroDto.setId(livro.getId());
        livroDto.setTitulo(livro.getTitulo());
        livroDto.setResumo(livro.getResumo());
        livroDto.setSumario(livro.getSumario());
        livroDto.setPreco(livro.getPreco());
        livroDto.setNumeroPaginas(livro.getNumeroPaginas());
        livroDto.setIsbn(livro.getIsbn());
        livroDto.setDataPublicacao(livro.getDataPublicacao());
        livroDto.setCategoriaId(livro.getCategoria().getId());
        livroDto.setAutorId(livro.getAutor().getId());
        return livroDto;
    }

    public static Livro TransformarDtoEmEntidade(LivroDto livroDto) {
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

    public static List<LivroDto> transformaListaLivroEmListaLivroDto(List<Livro> all) {
        List<LivroDto> dtos = null;
        for (Livro livro : all) {
            dtos.add(TransformarEntidadeEmDto(livro));
        }
        return dtos;
    }
}
