package com.example.livraria.custom;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {

    String message() default "O valor deve ser único";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
}