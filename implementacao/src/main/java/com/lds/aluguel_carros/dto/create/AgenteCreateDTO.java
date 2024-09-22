package com.lds.aluguel_carros.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
public class AgenteCreateDTO extends UsuarioCreateDTO {
    @NotBlank(message = "O CNPJ é obrigatório")
    @Pattern(regexp = "\\d{14}", message = "CNPJ inválido")
    @Schema(description = "CNPJ do agente", example = "12345678901234")
    private String cnpj;

    @NotBlank(message = "O cargo é obrigatório")
    @Schema(description = "Cargo do agente", example = "Gerente")
    private String cargo;
}