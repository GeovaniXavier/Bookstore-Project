package com.example.livraria.service;

import com.example.livraria.entity.Autor;
import com.example.livraria.entity.Categoria;
import com.example.livraria.entity.Livro;
import com.example.livraria.repository.LivroRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

class LivroServiceTest {

    @InjectMocks
    private LivroService livroService;

    @Mock
    private LivroRepository livroRepository;

    private Livro livro;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startLivro();
    }

    @Test
    void findAll() {
        Mockito.when(livroRepository.findAll()).thenReturn(java.util.List.of(livro));
        List<Livro> livros = livroService.findAll();
        Assertions.assertEquals(1, livros.size());
    }

    @Test
    void save() {
        Mockito.when(livroRepository.save(livro)).thenReturn(livro);
        Livro livroSaved = livroService.save(livro);
        Assertions.assertEquals(livro, livroSaved);
    }

    private void startLivro() {
        livro = new Livro();
        livro.setId(1L);
        livro.setTitulo("Great Expectations");
        livro.setResumo("Great Expectations is the thirteenth novel by Charles Dickens and his penultimate completed novel, which depicts the education of an orphan nicknamed Pip.");
        livro.setSumario("Great Expectations is the thirteenth novel by Charles Dickens and his penultimate completed novel, which depicts the education of an orphan nicknamed Pip.");
        livro.setPreco(10.0);
        livro.setDataPublicacao("1861-08-01");
        livro.setNumeroPaginas(505);
        livro.setIsbn("978-0141439563");

        Categoria categoria = new Categoria();
        categoria.setId(1L);
        livro.setCategoria(categoria);

        Autor autor = new Autor();
        autor.setId(1L);
        livro.setAutor(autor);
    }
}