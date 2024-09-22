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
public class FuncionarioEmpresaCreateDTO extends AgenteCreateDTO {
    @NotBlank(message = "A empresa é obrigatória")
    private String empresa;
}