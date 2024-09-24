package com.lds.aluguel_carros.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.lds.aluguel_carros.enums.PrazoAluguel;
import com.lds.aluguel_carros.enums.StatusPedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AluguelDTO {
    private Long id;
    private PrazoAluguel prazo;
    private StatusPedido status;
    private BigDecimal valor;
    private Date dataInicio;
    private ContratoAluguelDTO contrato;
    private AutomovelDTO automovel;
}