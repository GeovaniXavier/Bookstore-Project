package com.example.livraria.service;

import com.example.livraria.dto.AutorDto;
import com.example.livraria.entity.Autor;
import com.example.livraria.repository.AutorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

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
        startUser();
    }

    @Test
    void save() {
        Mockito.when(autorRepository.save(autor)).thenReturn(autor);
        Autor autorSaved = autorService.save(autor);
        Assertions.assertEquals(autor, autorSaved);
    }

    @Test
    void findAll() {
        Mockito.when(autorRepository.findAll()).thenReturn(List.of(autor));
        List<Autor> autores = autorService.findAll();
        Assertions.assertEquals(1, autores.size());
    }

    private void startUser() {
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