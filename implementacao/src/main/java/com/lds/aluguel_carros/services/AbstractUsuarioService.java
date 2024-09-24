package com.lds.aluguel_carros.services;

import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.apache.coyote.BadRequestException;
import org.apache.logging.log4j.LogManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.lds.aluguel_carros.config.JwtService;
import com.lds.aluguel_carros.dto.Login;
import com.lds.aluguel_carros.dto.UsuarioDTO;
import com.lds.aluguel_carros.dto.create.UsuarioCreateDTO;
import com.lds.aluguel_carros.entity.Usuario;
import com.lds.aluguel_carros.exception.BadCredentialsException;
import com.lds.aluguel_carros.exception.EntityExistsException;
import com.lds.aluguel_carros.mappers.IUsuarioMapper;
import com.lds.aluguel_carros.repository.IUsuarioRepository;

public abstract class AbstractUsuarioService<T extends Usuario, D extends UsuarioCreateDTO, K extends UsuarioDTO> implements IUsuarioService<T, D, K> {

    protected final IUsuarioRepository<T> repository;
    protected final IUsuarioMapper<T, D, K> mapper;
    protected final AuthenticationManager authenticationManager;
    protected final JwtService jwtService;
    protected final Logger logger;
    protected final UsuarioService usuarioService;

    public AbstractUsuarioService(IUsuarioRepository<T> repository, 
                                  IUsuarioMapper<T, D, K> mapper, 
                                  AuthenticationManager authenticationManager,
                                  JwtService jwtService,
                                  UsuarioService usuarioService) {
        this.repository = repository;
        this.mapper = mapper;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.usuarioService = usuarioService;
        this.logger = LogManager.getFormatterLogger(this);
    }

    @Override
    public void create(D user) throws BadRequestException {
        Optional<T> userExists = repository.findByEmail(user.getEmail());
        if (userExists.isPresent()) {
            throw new EntityExistsException("Usuário já cadastrado");
        }
        T usuario = mapper.toEntity(user);

        try {
            repository.save(usuario);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar usuário");
        }
    }

    @Override
    public String login(Login user) {
         authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getSenha()));
        T usuario = repository.findByEmailAndSenha(user.getEmail(), user.getSenha())
                .orElseThrow(() -> new BadCredentialsException("Usuário ou senha inválidos"));
        return jwtService.generateToken((Usuario) usuario);
    }

    @Override
    public void delete () {
        usuarioService.deleteCurrent();
    }
}