package com.lds.aluguel_carros.mappers;

import org.springframework.stereotype.Component;

import com.lds.aluguel_carros.dto.FuncionarioBancoDTO;
import com.lds.aluguel_carros.dto.create.FuncionarioBancoCreateDTO;
import com.lds.aluguel_carros.entity.FuncionarioBanco;

@Component
public class FuncionarioBancoMapper
        implements IUsuarioMapper<FuncionarioBanco, FuncionarioBancoCreateDTO, FuncionarioBancoDTO> {
    @Override
    public FuncionarioBanco toEntity(FuncionarioBancoCreateDTO dto) {
        return FuncionarioBanco.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .tipo(dto.getTipo())
                .cnpj(dto.getCnpj())
                .cargo(dto.getCargo())
                .banco(dto.getBanco())
                .build();
    }
}
