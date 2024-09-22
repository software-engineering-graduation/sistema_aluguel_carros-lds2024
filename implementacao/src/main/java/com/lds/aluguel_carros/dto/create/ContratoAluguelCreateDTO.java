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
public class ContratoAluguelCreateDTO {
    @NotNull(message = "O valor total é obrigatório")
    @Positive(message = "O valor total deve ser positivo")
    private BigDecimal valorTotal;

    @NotNull(message = "O ID do crédito é obrigatório")
    private Long creditoId;

    @NotNull(message = "O ID da propriedade é obrigatório")
    private Long propriedadeId;
}