package com.lds.aluguel_carros.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class FuncionarioEmpresa extends Agente {
    @NotBlank(message = "A empresa é obrigatória")
    @Schema(description = "Empresa do funcionário", example = "Empresa XYZ")
    private String empresa;
}