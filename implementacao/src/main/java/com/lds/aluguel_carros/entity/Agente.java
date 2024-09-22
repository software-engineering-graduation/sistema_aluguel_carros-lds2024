package com.lds.aluguel_carros.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
public class Agente extends Usuario {
    @NotBlank(message = "O CNPJ é obrigatório")
    @Pattern(regexp = "\\d{14}", message = "CNPJ inválido. Deve conter 14 dígitos")
    @Schema(description = "CNPJ do agente", example = "12345678000190")
    private String cnpj;

    @NotBlank(message = "O cargo é obrigatório")
    @Schema(description = "Cargo do agente", example = "Gerente de Vendas")
    private String cargo;
}