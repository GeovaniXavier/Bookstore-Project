package com.example.livraria.repository;

import com.example.livraria.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    //Create method to compare if an id already exists in the database

}
