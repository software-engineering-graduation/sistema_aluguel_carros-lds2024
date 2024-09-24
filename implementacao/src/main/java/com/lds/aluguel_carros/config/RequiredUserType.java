package com.lds.aluguel_carros.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.lds.aluguel_carros.entity.Usuario;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredUserType {
    Class<? extends Usuario>[] value();
}
