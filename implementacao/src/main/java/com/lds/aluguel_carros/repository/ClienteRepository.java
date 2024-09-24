package com.lds.aluguel_carros.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lds.aluguel_carros.entity.Cliente;

@Repository
public interface ClienteRepository extends IUsuarioRepository<Cliente> {
    Optional<Cliente> findByCpf(String cpf);
}
