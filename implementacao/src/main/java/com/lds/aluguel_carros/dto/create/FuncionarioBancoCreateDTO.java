package com.lds.aluguel_carros.dto.create;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FuncionarioBancoCreateDTO extends AgenteCreateDTO {
    @NotBlank(message = "O cargo é obrigatório")
    private String cargo;

    @NotBlank(message = "O banco é obrigatório")
    private String banco;
}