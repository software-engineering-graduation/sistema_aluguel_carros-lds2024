package com.lds.aluguel_carros.dto.create;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreditoCreateDTO {
    @NotNull(message = "O valor é obrigatório")
    @Positive(message = "O valor deve ser positivo")
    private BigDecimal valor;

    @NotNull(message = "A taxa de juros é obrigatória")
    @Positive(message = "A taxa de juros deve ser positiva")
    private BigDecimal taxaJuros;

    @NotNull(message = "O ID do concedente é obrigatório")
    private Long concedenteId;
}