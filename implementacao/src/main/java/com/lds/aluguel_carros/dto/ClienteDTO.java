package com.lds.aluguel_carros.dto;

import java.util.List;

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
public class ClienteDTO extends UsuarioDTO {
    private String rg;
    private String cpf;
    private String profissao;
    private String endereco;
    private List<RendimentoDTO> rendimentos;
}