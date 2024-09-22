package com.lds.aluguel_carros.dto;

import java.math.BigDecimal;

import com.lds.aluguel_carros.enums.StatusContrato;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ContratoAluguelDTO {
    private Long id;
    private StatusContrato status;
    private BigDecimal valorTotal;
    private CreditoDTO credito;
    private UsuarioDTO propriedade;
}