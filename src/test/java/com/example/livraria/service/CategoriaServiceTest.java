package com.example.livraria.service;

import com.example.livraria.dto.CategoriaDto;
import com.example.livraria.entity.Categoria;
import com.example.livraria.repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CategoriaServiceTest {

    @InjectMocks
    private CategoriaService categoriaService;

    @Mock
    private CategoriaRepository categoriaRepository;

    private Categoria categoria;

    private CategoriaDto categoriaDto;

    private Optional<Categoria> categoriaOptional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startCategoria();
    }

    @Test
    void save() {
        Mockito.when(categoriaRepository.save(categoria)).thenReturn(categoria);
        Categoria categoriaSaved = categoriaService.save(categoria);
        assertNotNull(categoriaSaved);
        assertEquals(categoria, categoriaSaved);

        assertEquals(categoria.getId(), categoriaSaved.getId());
        assertEquals(categoria.getNome(), categoriaSaved.getNome());
    }

    @Test
    void findAll() {
        Mockito.when(categoriaRepository.findAll()).thenReturn(java.util.List.of(categoria));
        List<Categoria> categorias = categoriaService.findAll();
        assertNotNull(categorias);
        assertEquals(1, categorias.size());

        Categoria categoria = categorias.get(0);

        assertEquals(this.categoria.getId(), categoria.getId());
        assertEquals(this.categoria.getNome(), categoria.getNome());
    }

    private void startCategoria() {
        categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNome("Fiction");
        categoriaDto = new CategoriaDto();
        categoriaDto.setId(1L);
        categoriaDto.setNome("Fiction");
        categoriaOptional = Optional.of(categoria);
    }
}