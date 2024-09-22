package com.lds.aluguel_carros.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lds.aluguel_carros.dto.Login;
import com.lds.aluguel_carros.dto.create.ClienteCreateDTO;
import com.lds.aluguel_carros.dto.create.FuncionarioBancoCreateDTO;
import com.lds.aluguel_carros.dto.create.FuncionarioEmpresaCreateDTO;
import com.lds.aluguel_carros.services.ClienteService;
import com.lds.aluguel_carros.services.FuncionarioBancoService;
import com.lds.aluguel_carros.services.FuncionarioEmpresaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentications", description = "Endpoints para autenticação de usuários")
@AllArgsConstructor
public class AuthController {
    private static final Logger logger = LogManager.getLogger(AuthController.class);

    private final ClienteService clienteService;
    private final FuncionarioBancoService funcionarioBancoService;
    private final FuncionarioEmpresaService funcionarioEmpresaService;

    @PostMapping("/register/cliente")
    @Operation(summary = "Cria um novo cliente", description = "Cria um novo cliente no sistema")
    @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso")
    @ApiResponse(responseCode = "409", description = "Cliente já cadastrado")
    public ResponseEntity<?> register(@Valid @RequestBody ClienteCreateDTO request) {
        clienteService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/register/funcionario/banco")
    @Operation(summary = "Cria um novo funcionário de banco", description = "Cria um novo funcionário de banco no sistema")
    @ApiResponse(responseCode = "201", description = "Funcionário de banco criado com sucesso")
    @ApiResponse(responseCode = "409", description = "Funcionário de banco já cadastrado")
    public ResponseEntity<?> register(@Valid @RequestBody FuncionarioBancoCreateDTO request) {
        funcionarioBancoService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/register/funcionario/empresa")
    @Operation(summary = "Cria um novo funcionário de empresa", description = "Cria um novo funcionário de empresa no sistema")
    @ApiResponse(responseCode = "201", description = "Funcionário de empresa criado com sucesso")
    public ResponseEntity<?> register(@Valid @RequestBody FuncionarioEmpresaCreateDTO request) {
        funcionarioEmpresaService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    @Operation(summary = "Autentica um usuário", description = "Autentica um usuário e retorna um token, contendo as informações do usuário autenticado (id e email)")
    @ApiResponse(responseCode = "200", description = "Usuário autenticado com sucesso", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = String.class)))
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = String.class)))
    public ResponseEntity<String> login(@Valid @RequestBody Login request) {
        logger.info("Login request: {}", request);
        try{
            return new ResponseEntity<String>(clienteService.login(request), HttpStatus.OK);
        } catch (Exception e) {
            try{
                return new ResponseEntity<String>(funcionarioBancoService.login(request), HttpStatus.OK);
            } catch (Exception e2) {
                try	{
                    return new ResponseEntity<String>(funcionarioEmpresaService.login(request), HttpStatus.OK);
                } catch (Exception e3) {
                    return new ResponseEntity<String>("Credenciais inválidas", HttpStatus.UNAUTHORIZED);
                }
            }
        }
    }
}
