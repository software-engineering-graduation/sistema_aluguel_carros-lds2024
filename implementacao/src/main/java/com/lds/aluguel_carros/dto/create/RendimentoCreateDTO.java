package com.lds.aluguel_carros.dto.create;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Nome do rendimento", example = "Empresa X")
    private String nome;

    @NotBlank(message = "O CNPJ é obrigatório")
    @Pattern(regexp = "\\d{14}", message = "CNPJ inválido")
    @Schema(description = "CNPJ do rendimento", example = "12345678000190")
    private String cnpj;

    @NotNull(message = "O status atual é obrigatório")
    @Schema(description = "Status atual do rendimento", example = "true")
    private boolean atual;

    @NotNull(message = "A renda é obrigatória")
    @Positive(message = "A renda deve ser um valor positivo")
    @Schema(description = "Renda do rendimento", example = "1000.00")
    private BigDecimal renda;

    @NotNull(message = "A data de início é obrigatória")
    @Past(message = "A data de início deve ser no passado")
    @Schema(description = "Data de início do rendimento", example = "2021-01-01")
    private Date dataInicio;

    @Schema(description = "Data de fim do rendimento", example = "2021-12-31")
    private Date dataFim;
}