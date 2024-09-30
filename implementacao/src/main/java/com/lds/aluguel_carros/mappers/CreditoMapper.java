package com.lds.aluguel_carros.mappers;

import org.springframework.stereotype.Component;

import com.lds.aluguel_carros.dto.CreditoDTO;
import com.lds.aluguel_carros.entity.Credito;
import com.lds.aluguel_carros.entity.FuncionarioBanco;

@Component
public class CreditoMapper {

    public CreditoMapper() {
    }

    public CreditoDTO toDTO(Credito credito) {
        if (credito == null) return null;
        FuncionarioBanco funcionarioBanco = credito.getConcedente();
        return CreditoDTO.builder()
                .id(credito.getId())
                .valor(credito.getValor())
                .taxaJuros(credito.getTaxaJuros())
                .concedenteCnpj(funcionarioBanco != null ? funcionarioBanco.getCnpj() : null)
                .concedenteNome(funcionarioBanco != null ? funcionarioBanco.getBanco() : null)
                .build();
    }
}
