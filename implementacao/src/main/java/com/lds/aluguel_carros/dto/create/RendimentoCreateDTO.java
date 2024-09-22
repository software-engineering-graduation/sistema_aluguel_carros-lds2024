package com.lds.aluguel_carros.dto.create;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RendimentoCreateDTO {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O CNPJ é obrigatório")
    @Pattern(regexp = "\\d{14}", message = "CNPJ inválido")
    private String cnpj;

    @NotNull(message = "O status atual é obrigatório")
    private boolean atual;

    @NotNull(message = "A renda é obrigatória")
    @Positive(message = "A renda deve ser um valor positivo")
    private BigDecimal renda;

    @NotNull(message = "A data de início é obrigatória")
    @Past(message = "A data de início deve ser no passado")
    private Date dataInicio;

    private Date dataFim;
}