package com.lds.aluguel_carros.services;

import java.math.BigDecimal;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import com.lds.aluguel_carros.dto.AluguelDTO;
import com.lds.aluguel_carros.dto.create.AluguelCreateDTO;
import com.lds.aluguel_carros.entity.Aluguel;
import com.lds.aluguel_carros.entity.Automovel;
import com.lds.aluguel_carros.entity.Cliente;
import com.lds.aluguel_carros.entity.ContratoAluguel;
import com.lds.aluguel_carros.enums.StatusAutomovel;
import com.lds.aluguel_carros.enums.StatusContrato;
import com.lds.aluguel_carros.enums.StatusPedido;
import com.lds.aluguel_carros.enums.TipoUsuario;
import com.lds.aluguel_carros.mappers.AluguelMapper;
import com.lds.aluguel_carros.repository.AluguelRepository;
import com.lds.aluguel_carros.repository.AutomovelRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AluguelService {
    private final AluguelRepository aluguelRepository;
    private final AutomovelRepository automovelRepository;
    private final AluguelMapper aluguelMapper;
    private final UsuarioService usuarioService;

    public AluguelDTO createAluguel(AluguelCreateDTO aluguelCreateDTO) throws BadRequestException {
        Automovel automovel = validateAutomovelAvailability(aluguelCreateDTO);
        Aluguel aluguel = aluguelMapper.toEntity(aluguelCreateDTO);
        ContratoAluguel contrato = createContrato(aluguelCreateDTO, automovel);
        Cliente cliente = usuarioService.getCurrentCliente();

        aluguel.setStatus(StatusPedido.PENDENTE);
        aluguel.setAutomovel(automovel);
        aluguel.setContrato(contrato);
        aluguel.setCliente(cliente);

        Aluguel savedAluguel = aluguelRepository.save(aluguel);
        return aluguelMapper.toDTO(savedAluguel);
    }

    private ContratoAluguel createContrato(AluguelCreateDTO aluguelCreateDTO, Automovel automovel) {
        return ContratoAluguel.builder()
                .status(StatusContrato.INATIVO)
                .valorTotal(calculateTotal(aluguelCreateDTO, automovel))
                .build();
    }

    private BigDecimal calculateTotal(AluguelCreateDTO aluguelCreateDTO, Automovel automovel) {
        return automovel.getValorMensal().multiply(aluguelCreateDTO.getPrazo().multiplier());
    }

    private Automovel validateAutomovelAvailability(AluguelCreateDTO aluguelCreateDTO) throws BadRequestException {
        Automovel automovel = automovelRepository.findById(aluguelCreateDTO.getAutomovelId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Automóvel não encontrado com o ID: " + aluguelCreateDTO.getAutomovelId()));

        if (!StatusAutomovel.DISPONIVEL.equals(automovel.getStatus())) {
            throw new BadRequestException(
                    "O automóvel com ID " + aluguelCreateDTO.getAutomovelId() + " não está disponível para aluguel.");
        }

        return automovel;
    }
}