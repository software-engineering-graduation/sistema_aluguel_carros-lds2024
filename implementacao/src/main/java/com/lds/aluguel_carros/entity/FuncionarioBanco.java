package com.lds.aluguel_carros.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioBanco extends Agente {
    @NotBlank(message = "O banco é obrigatório")
    @Schema(description = "Nome do banco", example = "Banco ABC")
    private String banco;
}