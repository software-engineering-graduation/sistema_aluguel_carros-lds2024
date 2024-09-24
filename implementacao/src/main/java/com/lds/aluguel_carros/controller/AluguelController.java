package com.lds.aluguel_carros.controller;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lds.aluguel_carros.config.RequiredUserType;
import com.lds.aluguel_carros.dto.AluguelDTO;
import com.lds.aluguel_carros.dto.create.AluguelCreateDTO;
import com.lds.aluguel_carros.entity.Cliente;
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
}