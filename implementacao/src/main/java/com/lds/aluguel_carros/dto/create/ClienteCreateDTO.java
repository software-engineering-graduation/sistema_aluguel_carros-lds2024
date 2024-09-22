package com.lds.aluguel_carros.dto.create;

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
public class ClienteCreateDTO extends UsuarioCreateDTO {
    @NotBlank(message = "O RG é obrigatório")
    private String rg;

    @NotBlank(message = "O CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "CPF inválido")
    private String cpf;

    @NotBlank(message = "A profissão é obrigatória")
    private String profissao;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;
}