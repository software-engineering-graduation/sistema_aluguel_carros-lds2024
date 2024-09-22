package com.lds.aluguel_carros.dto.create;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class AutomovelCreateDTO {
    @NotBlank(message = "A matrícula é obrigatória")
    private String matricula;

    @NotNull(message = "O ano é obrigatório")
    @Min(value = 1900, message = "O ano deve ser maior que 1900")
    private int ano;

    @NotBlank(message = "A marca é obrigatória")
    private String marca;

    @NotBlank(message = "O modelo é obrigatório")
    private String modelo;

    @NotBlank(message = "A placa é obrigatória")
    @Pattern(regexp = "[A-Z]{3}[0-9]{4}", message = "Placa inválida")
    private String placa;

    @NotNull(message = "O valor mensal é obrigatório")
    @Positive(message = "O valor mensal deve ser positivo")
    private BigDecimal valorMensal;

    @NotNull(message = "O ID do proprietário é obrigatório")
    private Long proprietarioId;
}