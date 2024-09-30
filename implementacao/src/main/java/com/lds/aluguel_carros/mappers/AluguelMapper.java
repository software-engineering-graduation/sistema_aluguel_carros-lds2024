package com.lds.aluguel_carros.mappers;

import org.springframework.stereotype.Component;

import com.lds.aluguel_carros.dto.AluguelDTO;
import com.lds.aluguel_carros.dto.create.AluguelCreateDTO;
import com.lds.aluguel_carros.entity.Aluguel;
import com.lds.aluguel_carros.entity.Usuario;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AluguelMapper {
    private final ContratoAluguelMapper contratoAluguelMapper;
    private final AutomovelMapper automovelMapper;

    public Aluguel toEntity(AluguelCreateDTO aluguelCreateDTO) {
        return Aluguel.builder()
                .prazo(aluguelCreateDTO.getPrazo())
                .dataInicio(aluguelCreateDTO.getDataInicio())
                .adquirirPropriedade(aluguelCreateDTO.isAdquirirPropriedade())
                .build();
    }
    
    public AluguelDTO toDTO(Aluguel savedAluguel, Usuario usuario) {
        return AluguelDTO.builder()
                .id(savedAluguel.getId())
                .prazo(savedAluguel.getPrazo())
                .status(savedAluguel.getStatus())
                .contrato(contratoAluguelMapper.toDTO(savedAluguel.getContrato(), savedAluguel.isAdquirirPropriedade(), usuario))
                .automovel(automovelMapper.toDTO(savedAluguel.getAutomovel(), savedAluguel.getCliente()))
                .build();
    }
}
