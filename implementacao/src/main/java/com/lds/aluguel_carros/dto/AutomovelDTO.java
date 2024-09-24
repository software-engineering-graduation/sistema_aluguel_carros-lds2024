package com.lds.aluguel_carros.dto;

import java.math.BigDecimal;

import com.lds.aluguel_carros.enums.StatusAutomovel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AutomovelDTO {
    private Long id;
    private String matricula;
    private int ano;
    private String marca;
    private String modelo;
    private String placa;
    private StatusAutomovel status;
    private BigDecimal valorMensal;
    private Long proprietarioIdentificacao;
}