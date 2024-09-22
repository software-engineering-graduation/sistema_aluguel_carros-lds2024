package com.lds.aluguel_carros.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
public class FuncionarioBanco extends Agente {
    @NotBlank(message = "O cargo é obrigatório")
    @Schema(description = "Cargo do funcionário do banco", example = "Gerente de Contas")
    private String cargo;

    @NotBlank(message = "O banco é obrigatório")
    @Schema(description = "Nome do banco", example = "Banco ABC")
    private String banco;
}