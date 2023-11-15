package com.example.livraria.custom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    private String domainField;
    private Class<?> klass;

    @Autowired
    @PersistenceContext
    private EntityManager em;

    @Override
    public void initialize(Unique params) {
        domainField = params.fieldName();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            // Valor nulo é considerado válido, altere conforme necessário
            return true;
        }

        if (em == null) {
            throw new IllegalStateException("O EntityManager não foi injetado corretamente.");
        }

        String jpql = "SELECT COUNT(e) FROM " + klass.getSimpleName() + " e WHERE e." + domainField + " = :value";

        try {
            return em.createQuery(jpql, Long.class)
                    .setParameter("value", value)
                    .getSingleResult() == 0;
        } catch (NoResultException e) {
            return true; // Trate como válido se nenhum resultado for encontrado
        } catch (Exception e) {
            // Log da exceção para diagnóstico, ajuste conforme necessário
            e.printStackTrace();
            throw new RuntimeException("Erro durante a validação: " + e.getMessage(), e);
        }
    }
}
