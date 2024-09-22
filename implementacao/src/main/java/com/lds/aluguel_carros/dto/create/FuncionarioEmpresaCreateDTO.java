package com.lds.aluguel_carros.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Empresa do funcionário", example = "Empresa XYZ")
    private String empresa;
}