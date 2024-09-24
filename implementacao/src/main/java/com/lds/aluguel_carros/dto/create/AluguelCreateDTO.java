package com.lds.aluguel_carros.dto.create;

import java.util.Date;

import com.lds.aluguel_carros.enums.PrazoAluguel;

import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "A data de início é obrigatória")
    private Date dataInicio;

    @NotNull(message = "O ID do automóvel é obrigatório")
    private Long automovelId;

    @NotNull(message = "A opção de adquirir propriedade é obrigatória")
    private boolean adquirirPropriedade;
}