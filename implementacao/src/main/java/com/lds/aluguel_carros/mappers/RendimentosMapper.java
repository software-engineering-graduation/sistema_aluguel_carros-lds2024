package com.lds.aluguel_carros.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lds.aluguel_carros.dto.create.RendimentoCreateDTO;
import com.lds.aluguel_carros.entity.Rendimento;

@Component
public class RendimentosMapper {
    public Rendimento toEntity(RendimentoCreateDTO rendimento) {
        return Rendimento.builder()
                .nome(rendimento.getNome())
                .cnpj(rendimento.getCnpj())
                .atual(rendimento.isAtual())
                .renda(rendimento.getRenda())
                .dataInicio(rendimento.getDataInicio())
                .dataFim(rendimento.getDataFim())
                .build();

    }

    public List<Rendimento> toEntity(List<RendimentoCreateDTO> rendimento) {
        return rendimento.stream().map(this::toEntity).toList();
    }
}
