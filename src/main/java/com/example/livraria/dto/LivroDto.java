package com.example.livraria.dto;

import com.example.livraria.custom.Unique;
import com.example.livraria.entity.Livro;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

public class LivroDto {

    private Long id;

    @NotNull
    @Unique(domainClass = Livro.class, fieldName = "titulo", message = "Título já está em uso")
    private String titulo;

    @Column(length = 500)
    private String resumo;

    private String sumario;

    private Double preco;

    private Integer numeroPaginas;

    private String isbn;

    private String dataPublicacao;

    @OneToOne
    private Long CategoriaId;

    @OneToOne
    private Long AutorId;

    public LivroDto() {
    }

    public LivroDto(Long id, String titulo, String resumo, String sumario, Double preco, Integer numeroPaginas, String isbn, String dataPublicacao, Long categoriaId, Long autorId) {
        this.id = id;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        CategoriaId = categoriaId;
        AutorId = autorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Long getCategoriaId() {
        return CategoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        CategoriaId = categoriaId;
    }

    public Long getAutorId() {
        return AutorId;
    }

    public void setAutorId(Long autorId) {
        AutorId = autorId;
    }
}
