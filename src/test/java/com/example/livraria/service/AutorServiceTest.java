package com.example.livraria.service;

import com.example.livraria.dto.AutorDto;
import com.example.livraria.entity.Autor;
import com.example.livraria.repository.AutorRepository;
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

class AutorServiceTest {

    @InjectMocks
    private AutorService autorService;
    @Mock
    private AutorRepository autorRepository;
    private Autor autor;
    private AutorDto autorDto;
    private Optional<Autor> autorOptional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startAutor();
    }

    @Test
    void save() {
        Mockito.when(autorRepository.save(autor)).thenReturn(autor);
        Autor autorSaved = autorService.save(autor);
        assertNotNull(autorSaved);
        assertEquals(autor, autorSaved);

        assertEquals(autor.getId(), autorSaved.getId());
        assertEquals(autor.getNome(), autorSaved.getNome());
        assertEquals(autor.getDescricao(), autorSaved.getDescricao());
        assertEquals(autor.getEmail(), autorSaved.getEmail());
    }

    @Test
    void findAll() {
        Mockito.when(autorRepository.findAll()).thenReturn(List.of(autor));
        List<Autor> autores = autorService.findAll();
        assertNotNull(autores);
        assertEquals(1, autores.size());

        Autor autor = autores.get(0);
        assertEquals(this.autor.getId(), autor.getId());
        assertEquals(this.autor.getNome(), autor.getNome());
        assertEquals(this.autor.getDescricao(), autor.getDescricao());
        assertEquals(this.autor.getEmail(), autor.getEmail());
    }

    private void startAutor() {
        autor = new Autor();
        autor.setId(1L);
        autor.setNome("Charles Dickens");
        autor.setDescricao("Renowned English writer");
        autor.setEmail("charles.dickens@example.com");
        autorDto = new AutorDto();
        autorDto.setId(1L);
        autorDto.setNome("Charles Dickens");
        autorDto.setDescricao("Renowned English writer");
        autorDto.setEmail("charles.dickens@example.com");
        autorOptional = Optional.of(autor);
    }
}