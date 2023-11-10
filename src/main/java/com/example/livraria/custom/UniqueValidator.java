package com.example.livraria.custom;

import com.example.livraria.entity.Autor;
import com.example.livraria.repository.AutorRepository;
import com.example.livraria.repository.CategoriaRepository;
import com.example.livraria.service.AutorService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    @Autowired
    private AutorRepository autorRepository; // Substitua YourRepository pelo nome do seu repositório Spring Data JPA.

    @Autowired
    private AutorService autorService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void initialize(Unique constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Trate o caso de valor nulo conforme necessário
        }

        Autor autor = (Autor) value;

        if (autorRepository.isValueUnique(autor)) {
            return true;
        } else {
            return false;
        }
    }
}
