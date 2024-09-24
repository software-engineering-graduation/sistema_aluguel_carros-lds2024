package com.lds.aluguel_carros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lds.aluguel_carros.entity.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
