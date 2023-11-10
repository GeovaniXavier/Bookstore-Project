package com.example.livraria.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CategoriaDto {

    private Long id;

    @NotNull
    @NotBlank
    @Column(unique = true)
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
