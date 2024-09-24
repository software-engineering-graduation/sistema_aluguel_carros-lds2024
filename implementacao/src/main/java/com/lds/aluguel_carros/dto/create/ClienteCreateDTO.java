package com.lds.aluguel_carros.dto.create;

import java.util.List;

import com.lds.aluguel_carros.enums.TipoUsuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ClienteCreateDTO extends UsuarioCreateDTO {
    @NotBlank(message = "O RG é obrigatório")
    @Pattern(regexp = "\\d{1,9}", message = "RG inválido. Deve conter no máximo 9 dígitos")
    @Schema(example = "12123123")
    private String rg;

    @NotBlank(message = "O CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "CPF inválido")
    private String cpf;

    @NotBlank(message = "A profissão é obrigatória")
    private String profissao;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    @NotEmpty(message = "É necessário informar seus rendimentos")
    @NotNull(message = "É necessário informar seus rendimentos")
    private List<RendimentoCreateDTO> rendimentos;

    public ClienteCreateDTO(String nome,
            String email,
            String senha,
            String rg,
            String cpf,
            String profissao,
            String endereco,
            List<RendimentoCreateDTO> rendimentos) {
        super(nome, email, senha, TipoUsuario.CLIENTE);
        this.rg = rg;
        this.cpf = cpf;
        this.profissao = profissao;
        this.endereco = endereco;
        this.rendimentos = rendimentos;
    }
}