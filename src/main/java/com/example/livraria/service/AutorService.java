package com.example.livraria.service;

import com.example.livraria.entity.Autor;
import com.example.livraria.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {


    @Autowired
    private AutorRepository autorRepository;

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }
}
