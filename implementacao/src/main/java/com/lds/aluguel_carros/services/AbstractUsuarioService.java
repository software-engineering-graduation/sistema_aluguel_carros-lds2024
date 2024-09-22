package com.lds.aluguel_carros.services;

import java.util.Optional;

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

public abstract class AbstractUsuarioService<T extends Usuario, D extends UsuarioCreateDTO, K extends UsuarioDTO> implements IUsuarioService<T, D> {

    protected final IUsuarioRepository<T> repository;
    protected final IUsuarioMapper<T, D, K> mapper;
    protected final AuthenticationManager authenticationManager;
    protected final JwtService jwtService;

    public AbstractUsuarioService(IUsuarioRepository<T> repository, 
                                  IUsuarioMapper<T, D, K> mapper, 
                                  AuthenticationManager authenticationManager,
                                  JwtService jwtService) {
        this.repository = repository;
        this.mapper = mapper;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public void create(D user) {
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
}