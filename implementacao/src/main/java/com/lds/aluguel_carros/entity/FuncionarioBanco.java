package com.lds.aluguel_carros.entity;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@EqualsAndHashCode(callSuper = false)
public class FuncionarioBanco extends Agente {
    @NotBlank(message = "O banco é obrigatório")
    @Schema(description = "Nome do banco", example = "Banco ABC")
    private String banco;

    @OneToMany(mappedBy = "concedente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Credito> creditos;
}