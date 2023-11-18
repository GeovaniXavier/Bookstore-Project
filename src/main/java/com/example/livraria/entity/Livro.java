package com.example.livraria.entity;

import com.example.livraria.custom.Unique;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Categoria Categoria;

    @OneToOne
    private Autor Autor;

    public Livro() {
    }

    public Livro(Long id, String titulo, String resumo, String sumario, Double preco, Integer numeroPaginas, String isbn, String dataPublicacao, com.example.livraria.entity.Categoria categoria, com.example.livraria.entity.Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        Categoria = categoria;
        Autor = autor;
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

    public com.example.livraria.entity.Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(com.example.livraria.entity.Categoria categoria) {
        Categoria = categoria;
    }

    public com.example.livraria.entity.Autor getAutor() {
        return Autor;
    }

    public void setAutor(com.example.livraria.entity.Autor autor) {
        Autor = autor;
    }
}
