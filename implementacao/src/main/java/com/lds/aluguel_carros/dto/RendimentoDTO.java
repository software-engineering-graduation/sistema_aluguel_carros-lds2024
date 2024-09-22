package com.lds.aluguel_carros.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RendimentoDTO {
    private Long id;
    private String nome;
    private String cnpj;
    private boolean atual;
    private BigDecimal renda;
    private Date dataInicio;
    private Date dataFim;
}