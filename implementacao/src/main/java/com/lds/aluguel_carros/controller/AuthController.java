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
import com.lds.aluguel_carros.exception.BadCredentialsException;
import com.lds.aluguel_carros.services.ClienteService;
import com.lds.aluguel_carros.services.FuncionarioBancoService;
import com.lds.aluguel_carros.services.FuncionarioEmpresaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentications", description = "Endpoints para autenticação de usuários")
@AllArgsConstructor
public class AuthController {
    private static final Logger logger = LogManager.getLogger(AuthController.class);

    // @PostMapping
    // @Operation(summary = "Autentica um usuário", description = "Autentica um
    // usuário e retorna um token, contendo as informações do usuário autenticado
    // (id e email)")
    // @ApiResponse(responseCode = "200", description = "Usuário autenticado com
    // sucesso", content = @Content(mediaType = "application/json", schema =
    // @Schema(implementation = String.class)))
    // @ApiResponse(responseCode = "401", description = "Credenciais inválidas",
    // content = @Content(mediaType = "application/json", schema =
    // @Schema(implementation = String.class)))
    // @ApiResponse(responseCode = "404", description = "Usuário não encontrado",
    // content = @Content(mediaType = "application/json", schema =
    // @Schema(implementation = String.class)))
    // public ResponseEntity<String> login(
    // @Parameter(description = "Objeto contendo as credenciais do usuário")
    // @RequestBody Login login) {
    // logger.info("Logging in user with email: {}", login.getEmail());
    // logger.info("Logging in user with password: {}", login.getSenha());

    // UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
    // UsernamePasswordAuthenticationToken(
    // login.getEmail(), login.getSenha());

    // Authentication authenticated =
    // this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

    // Usuario user = (Usuario) authenticated.getPrincipal();

    // logger.info("Usuario " + user.getEmail() + " logged in");
    // String token = filterToken.generateToken(user);
    // logger.info("Token generated for user " + user.getEmail() + ": " + token);

    // // Retorna um ResponseEntity com o token
    // return new ResponseEntity<>(token, HttpStatus.OK);
    // }

    // @PostMapping
    // public ResponseEntity<String> login(@RequestBody Login login) {
    // if ("joao.silva@email.com".equals(login.getEmail()) &&
    // "senha123".equals(login.getSenha())) {
    // // Generate and return token
    // String token = "dummy_token";
    // return new ResponseEntity<>(token, HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
    // }
    // }

    private final ClienteService clienteService;
    private final FuncionarioBancoService funcionarioBancoService;
    private final FuncionarioEmpresaService funcionarioEmpresaService;

    @PostMapping("/register/cliente")
    @Operation(summary = "Cria um novo cliente", description = "Cria um novo cliente no sistema")
    public ResponseEntity<?> register(@Valid @RequestBody ClienteCreateDTO request) {
        clienteService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/register/funcionario/banco")
    public ResponseEntity<?> register(@Valid @RequestBody FuncionarioBancoCreateDTO request) {
        funcionarioBancoService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/register/funcionario/empresa")
    public ResponseEntity<?> register(@Valid @RequestBody FuncionarioEmpresaCreateDTO request) {
        funcionarioEmpresaService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> login(@Valid @RequestBody Login request) {
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
