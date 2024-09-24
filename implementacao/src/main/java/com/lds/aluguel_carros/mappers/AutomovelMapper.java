package com.lds.aluguel_carros.mappers;

import org.springframework.stereotype.Component;

import com.lds.aluguel_carros.dto.AutomovelDTO;
import com.lds.aluguel_carros.entity.Automovel;
import com.lds.aluguel_carros.entity.Cliente;

@Component
public class AutomovelMapper {
    public AutomovelDTO toDTO(Automovel automovel, Cliente cliente) {
        if (automovel == null) return null;
        return AutomovelDTO.builder()
                .id(automovel.getId())
                .matricula(automovel.getMatricula())
                .ano(automovel.getAno())
                .marca(automovel.getMarca())
                .modelo(automovel.getModelo())
                .placa(automovel.getPlaca())
                .status(automovel.getStatus())
                .valorMensal(automovel.getValorMensal())
                .proprietarioIdentificacao(cliente != null ? cliente.getId() : null)
                .build();
    }
}
