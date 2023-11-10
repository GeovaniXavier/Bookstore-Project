package com.example.livraria.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class AutorDto {


    private Long id;

    @NotNull
    private LocalDateTime instante;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String nome;


    @Column(length = 400)
    @NotNull
    private String descricao;

    public AutorDto() {
    }

    public AutorDto(Long id, LocalDateTime instante, String email, String nome, String descricao) {
        this.id = id;
        this.instante = instante;
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public void setInstante(LocalDateTime instante) {
        this.instante = instante;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
