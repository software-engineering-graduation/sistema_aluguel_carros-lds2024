package com.lds.aluguel_carros.mappers;

import org.springframework.stereotype.Component;

import com.lds.aluguel_carros.dto.FuncionarioEmpresaDTO;
import com.lds.aluguel_carros.dto.create.FuncionarioEmpresaCreateDTO;
import com.lds.aluguel_carros.entity.FuncionarioEmpresa;

@Component
public class FuncionarioEmpresaMapper
        implements IUsuarioMapper<FuncionarioEmpresa, FuncionarioEmpresaCreateDTO, FuncionarioEmpresaDTO> {
    @Override
    public FuncionarioEmpresa toEntity(FuncionarioEmpresaCreateDTO dto) {
        return FuncionarioEmpresa.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .tipo(dto.getTipo())
                .cnpj(dto.getCnpj())
                .cargo(dto.getCargo())
                .empresa(dto.getEmpresa())
                .build();
    }

    @Override
    public FuncionarioEmpresaDTO toDTO(FuncionarioEmpresa entity) {
        return FuncionarioEmpresaDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .tipo(entity.getTipo())
                .cnpj(entity.getCnpj())
                .cargo(entity.getCargo())
                .empresa(entity.getEmpresa())
                .build();
    }
}
