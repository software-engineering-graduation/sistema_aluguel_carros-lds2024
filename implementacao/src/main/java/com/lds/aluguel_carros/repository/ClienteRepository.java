package com.lds.aluguel_carros.repository;

import org.springframework.stereotype.Repository;

import com.lds.aluguel_carros.entity.Cliente;

@Repository
public interface ClienteRepository extends IUsuarioRepository<Cliente> {
}
