package com.lds.aluguel_carros.controller;

import java.util.Date;

import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lds.aluguel_carros.config.RequiredUserType;
import com.lds.aluguel_carros.dto.AluguelDTO;
import com.lds.aluguel_carros.dto.create.AluguelCreateDTO;
import com.lds.aluguel_carros.entity.Cliente;
import com.lds.aluguel_carros.enums.StatusPedido;
import com.lds.aluguel_carros.services.AluguelService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/aluguel")
@Tag(name = "Alugueis", description = "Endpoints para gerenciamento de alugueis")
@SecurityRequirement(name = "Bearer Authentication")
@AllArgsConstructor
public class AluguelController {
    private final AluguelService aluguelService;

    @PostMapping
    @Operation(summary = "Cria um novo pedido de aluguel", description = "Cria um novo pedido de aluguel no sistema")
    @ApiResponse(responseCode = "201", description = "Pedido de aluguel criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Não autorizado")
    @RequiredUserType(Cliente.class)
    public ResponseEntity<AluguelDTO> createAluguel(@Valid @RequestBody AluguelCreateDTO aluguelCreateDTO) throws BadRequestException {
        AluguelDTO createdAluguel = aluguelService.createAluguel(aluguelCreateDTO);
        return new ResponseEntity<>(createdAluguel, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Lista pedidos de aluguel", description = "Lista os pedidos de aluguel com filtros e ordenação")
    @ApiResponse(responseCode = "200", description = "Lista de pedidos de aluguel retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Não autorizado")
    @RequiredUserType(Cliente.class)
    public ResponseEntity<Page<AluguelDTO>> listAlugueis(
            @RequestParam(required = false) StatusPedido status,
            @RequestParam(required = false) Boolean adquirirPropriedade,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataInicio,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "dataInicio") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection) {

        Page<AluguelDTO> alugueis = aluguelService.listAlugueis(status, adquirirPropriedade, dataInicio, page, size, sortBy, sortDirection);
        return ResponseEntity.ok(alugueis);
    }
}