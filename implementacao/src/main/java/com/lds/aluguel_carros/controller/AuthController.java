package com.lds.aluguel_carros.controller;

import org.apache.coyote.BadRequestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lds.aluguel_carros.dto.ClienteDTO;
import com.lds.aluguel_carros.dto.FuncionarioBancoDTO;
import com.lds.aluguel_carros.dto.FuncionarioEmpresaDTO;
import com.lds.aluguel_carros.dto.Login;
import com.lds.aluguel_carros.dto.create.ClienteCreateDTO;
import com.lds.aluguel_carros.dto.create.FuncionarioBancoCreateDTO;
import com.lds.aluguel_carros.dto.create.FuncionarioEmpresaCreateDTO;
import com.lds.aluguel_carros.services.ClienteService;
import com.lds.aluguel_carros.services.FuncionarioBancoService;
import com.lds.aluguel_carros.services.FuncionarioEmpresaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
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
    public ResponseEntity<?> register(@Valid @RequestBody ClienteCreateDTO request) throws BadRequestException {
        clienteService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/register/funcionario/banco")
    @Operation(summary = "Cria um novo funcionário de banco", description = "Cria um novo funcionário de banco no sistema")
    @ApiResponse(responseCode = "201", description = "Funcionário de banco criado com sucesso")
    @ApiResponse(responseCode = "409", description = "Funcionário de banco já cadastrado")
    public ResponseEntity<?> register(@Valid @RequestBody FuncionarioBancoCreateDTO request)
            throws BadRequestException {
        funcionarioBancoService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/register/funcionario/empresa")
    @Operation(summary = "Cria um novo funcionário de empresa", description = "Cria um novo funcionário de empresa no sistema")
    @ApiResponse(responseCode = "201", description = "Funcionário de empresa criado com sucesso")
    public ResponseEntity<?> register(@Valid @RequestBody FuncionarioEmpresaCreateDTO request)
            throws BadRequestException {
        funcionarioEmpresaService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/me")
    @Operation(summary = "Get current user", description = "Retrieves the information of the currently authenticated user. The response type depends on the user type (Cliente, FuncionarioBanco, or FuncionarioEmpresa).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User information retrieved successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(oneOf = {
                            ClienteDTO.class,
                            FuncionarioBancoDTO.class,
                            FuncionarioEmpresaDTO.class
                    }))
            }),
            @ApiResponse(responseCode = "401", description = "User not authenticated", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<?> getCurrentUser() {
        try {
            ClienteDTO clienteDTO = clienteService.getCurrentUser();
            return ResponseEntity.ok(clienteDTO);
        } catch (Exception e) {
            try {
                FuncionarioBancoDTO funcionarioBancoDTO = funcionarioBancoService.getCurrentUser();
                return ResponseEntity.ok(funcionarioBancoDTO);
            } catch (Exception e2) {
                try {
                    FuncionarioEmpresaDTO funcionarioEmpresaDTO = funcionarioEmpresaService.getCurrentUser();
                    return ResponseEntity.ok(funcionarioEmpresaDTO);
                } catch (Exception e3) {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated");
                }
            }
        }
    }

    // @PutMapping("/me")
    // @Operation(summary = "Update current user", description = "Updates the
    // information of the currently authenticated user")
    // @ApiResponse(responseCode = "200", description = "User information updated
    // successfully")
    // @ApiResponse(responseCode = "401", description = "User not authenticated")
    // public ResponseEntity<UsuarioDTO> updateCurrentUser(@Valid @RequestBody
    // UsuarioDTO request) {
    // UsuarioDTO updatedUser = null;
    // try {
    // updatedUser = clienteService.update(request);
    // } catch (Exception e) {
    // try {
    // updatedUser = funcionarioBancoService.update(request);
    // } catch (Exception e2) {
    // updatedUser = funcionarioEmpresaService.update(request);
    // }
    // }
    // return ResponseEntity.ok(updatedUser);
    // }

    @DeleteMapping("/me")
    @Operation(summary = "Delete current user", description = "Deletes the account of the currently authenticated user")
    @ApiResponse(responseCode = "204", description = "User account deleted successfully")
    @ApiResponse(responseCode = "401", description = "User not authenticated")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<?> deleteCurrentUser() {
        try {
            clienteService.delete();
        } catch (Exception e) {
            try {
                funcionarioBancoService.delete();
            } catch (Exception e2) {
                funcionarioEmpresaService.delete();
            }
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/authenticate")
    @Operation(summary = "Autentica um usuário", description = "Autentica um usuário e retorna um token, contendo as informações do usuário autenticado (id e email)")
    @ApiResponse(responseCode = "200", description = "Usuário autenticado com sucesso", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = String.class)))
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = String.class)))
    public ResponseEntity<String> login(@Valid @RequestBody Login request) {
        logger.info("Login request: {}", request);
        try {
            return new ResponseEntity<String>(clienteService.login(request), HttpStatus.OK);
        } catch (Exception e) {
            try {
                return new ResponseEntity<String>(funcionarioBancoService.login(request), HttpStatus.OK);
            } catch (Exception e2) {
                try {
                    return new ResponseEntity<String>(funcionarioEmpresaService.login(request), HttpStatus.OK);
                } catch (Exception e3) {
                    return new ResponseEntity<String>("Credenciais inválidas", HttpStatus.UNAUTHORIZED);
                }
            }
        }
    }
}
