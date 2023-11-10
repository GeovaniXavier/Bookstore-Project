package com.example.livraria.custom;

import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {
    String message() default "Valor duplicado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
