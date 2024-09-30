package com.lds.aluguel_carros.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lds.aluguel_carros.dto.ContratoAluguelDTO;
import com.lds.aluguel_carros.entity.ContratoAluguel;
import com.lds.aluguel_carros.entity.Usuario;

@Component
public class ContratoAluguelMapper {
    
    @Autowired
    CreditoMapper creditoMapper;
    @Autowired
    UsuarioMapper usuarioMapper;

    public ContratoAluguelDTO toDTO(ContratoAluguel contrato) {
        return ContratoAluguelDTO.builder()
                .id(contrato.getId())
                .status(contrato.getStatus())
                .valorTotal(contrato.getValorTotal())
                .credito(creditoMapper.toDTO(contrato.getCredito()))
                .build();
    }

    public ContratoAluguelDTO toDTO(ContratoAluguel contrato, boolean adquirirPropriedade, Usuario usuario) {
        return ContratoAluguelDTO.builder()
                .id(contrato.getId())
                .status(contrato.getStatus())
                .valorTotal(contrato.getValorTotal())
                .credito(creditoMapper.toDTO(contrato.getCredito()))
                .propriedade(adquirirPropriedade ? usuarioMapper.toDTO(usuario) : null)
                .build();
    }
}
