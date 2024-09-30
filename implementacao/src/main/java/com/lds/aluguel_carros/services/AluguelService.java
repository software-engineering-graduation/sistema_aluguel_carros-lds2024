package com.lds.aluguel_carros.services;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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
        return aluguelMapper.toDTO(savedAluguel, cliente);
    }

    public Page<AluguelDTO> listAlugueis(StatusPedido status, Boolean adquirirPropriedade, Date dataInicio, int page, int size, String sortBy, String sortDirection) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));

        Specification<Aluguel> spec = Specification.where(null);

        if (status != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status));
        }

        if (adquirirPropriedade != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("adquirirPropriedade"), adquirirPropriedade));
        }

        if (dataInicio != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("dataInicio"), dataInicio));
        }

        Page<Aluguel> alugueis = aluguelRepository.findAll(spec, pageable);
        return alugueis.map(aluguel -> aluguelMapper.toDTO(aluguel, usuarioService.getCurrentCliente()));
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