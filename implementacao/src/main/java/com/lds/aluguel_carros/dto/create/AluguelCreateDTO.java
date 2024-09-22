package com.lds.aluguel_carros.dto.create;

import java.math.BigDecimal;
import java.util.Date;

import com.lds.aluguel_carros.enums.PrazoAluguel;

import jakarta.validation.constraints.Future;
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
public class AluguelCreateDTO {
    @NotNull(message = "O prazo é obrigatório")
    private PrazoAluguel prazo;

    @NotNull(message = "O valor é obrigatório")
    @Positive(message = "O valor deve ser positivo")
    private BigDecimal valor;

    @NotNull(message = "A data de início é obrigatória")
    @Future(message = "A data de início deve ser no futuro")
    private Date dataInicio;

    @NotNull(message = "O ID do automóvel é obrigatório")
    private Long automovelId;

    @NotNull(message = "A opção de adquirir propriedade é obrigatória")
    private boolean adquirirPropriedade;
}