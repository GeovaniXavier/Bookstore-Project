package com.example.livraria.dto;

import com.example.livraria.custom.Unique;
import com.example.livraria.entity.Categoria;

public class CategoriaDto {

    private Long id;

    @Unique(domainClass = Categoria.class, fieldName = "nome", message = "Nome já está em uso")
    private String nome;

    public CategoriaDto() {
    }

    public CategoriaDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
