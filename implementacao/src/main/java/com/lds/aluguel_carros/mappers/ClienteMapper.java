package com.lds.aluguel_carros.mappers;

import org.springframework.stereotype.Component;

import com.lds.aluguel_carros.dto.ClienteDTO;
import com.lds.aluguel_carros.dto.create.ClienteCreateDTO;
import com.lds.aluguel_carros.entity.Cliente;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClienteMapper
        implements IUsuarioMapper<Cliente, ClienteCreateDTO, ClienteDTO> {

    private final RendimentosMapper rendimentosMapper;

    @Override
    public Cliente toEntity(ClienteCreateDTO dto) {
        return Cliente.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .tipo(dto.getTipo())
                .rg(dto.getRg())
                .cpf(dto.getCpf())
                .profissao(dto.getProfissao())
                .endereco(dto.getEndereco())
                .rendimentos(rendimentosMapper.toEntity(dto.getRendimentos()))
                .build();
    }

    @Override
    public ClienteDTO toDTO(Cliente entity) {
        return ClienteDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .tipo(entity.getTipo())
                .rg(entity.getRg())
                .cpf(entity.getCpf())
                .profissao(entity.getProfissao())
                .endereco(entity.getEndereco())
                .rendimentos(rendimentosMapper.toDTO(entity.getRendimentos()))
                .build();
    }
}
