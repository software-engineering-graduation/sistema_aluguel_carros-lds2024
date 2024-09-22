package com.lds.aluguel_carros.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.lds.aluguel_carros.entity.Usuario;

@NoRepositoryBean
public interface IUsuarioRepository<T extends Usuario> extends JpaRepository<T, Long> {
    Optional<T> findByEmail(String email);

    Optional<T> findByEmailAndSenha(String email, String senha);
}