package com.lds.aluguel_carros.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lds.aluguel_carros.dto.ContratoAluguelDTO;
import com.lds.aluguel_carros.entity.ContratoAluguel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ContratoAluguelMapper {
    
    @Autowired
    CreditoMapper creditoMapper;

    public ContratoAluguelDTO toDTO(ContratoAluguel contrato) {
        return ContratoAluguelDTO.builder()
                .id(contrato.getId())
                .status(contrato.getStatus())
                .valorTotal(contrato.getValorTotal())
                .credito(creditoMapper.toDTO(contrato.getCredito()))
                .build();
    }
}
