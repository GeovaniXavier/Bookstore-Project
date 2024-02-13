package com.example.livraria.service;

import com.example.livraria.entity.Autor;
import com.example.livraria.entity.Categoria;
import com.example.livraria.entity.Livro;
import com.example.livraria.repository.LivroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        assertNotNull(livros);
        assertEquals(1, livros.size());

        Livro livro = livros.get(0);
        assertEquals(this.livro.getId(), livro.getId());
        assertEquals(this.livro.getTitulo(), livro.getTitulo());
        assertEquals(this.livro.getResumo(), livro.getResumo());
        assertEquals(this.livro.getSumario(), livro.getSumario());
        assertEquals(this.livro.getPreco(), livro.getPreco());
        assertEquals(this.livro.getDataPublicacao(), livro.getDataPublicacao());
        assertEquals(this.livro.getNumeroPaginas(), livro.getNumeroPaginas());
        assertEquals(this.livro.getIsbn(), livro.getIsbn());
        assertEquals(this.livro.getCategoria(), livro.getCategoria());
        assertEquals(this.livro.getAutor(), livro.getAutor());
    }

    @Test
    void save() {
        Mockito.when(livroRepository.save(livro)).thenReturn(livro);
        Livro livroSaved = livroService.save(livro);
        assertNotNull(livroSaved);
        assertEquals(livro, livroSaved);

        assertEquals(livro.getId(), livroSaved.getId());
        assertEquals(livro.getTitulo(), livroSaved.getTitulo());
        assertEquals(livro.getResumo(), livroSaved.getResumo());
        assertEquals(livro.getSumario(), livroSaved.getSumario());
        assertEquals(livro.getPreco(), livroSaved.getPreco());
        assertEquals(livro.getDataPublicacao(), livroSaved.getDataPublicacao());
        assertEquals(livro.getNumeroPaginas(), livroSaved.getNumeroPaginas());
        assertEquals(livro.getIsbn(), livroSaved.getIsbn());
        assertEquals(livro.getCategoria(), livroSaved.getCategoria());
        assertEquals(livro.getAutor(), livroSaved.getAutor());

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