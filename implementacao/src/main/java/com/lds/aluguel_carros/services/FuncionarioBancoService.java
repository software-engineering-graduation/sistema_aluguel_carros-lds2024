package com.lds.aluguel_carros.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import com.lds.aluguel_carros.config.JwtService;
import com.lds.aluguel_carros.dto.FuncionarioBancoDTO;
import com.lds.aluguel_carros.dto.create.FuncionarioBancoCreateDTO;
import com.lds.aluguel_carros.entity.FuncionarioBanco;
import com.lds.aluguel_carros.mappers.FuncionarioBancoMapper;
import com.lds.aluguel_carros.repository.FuncionarioBancoRepository;

@Service
public class FuncionarioBancoService
        extends AbstractUsuarioService<FuncionarioBanco, FuncionarioBancoCreateDTO, FuncionarioBancoDTO> {
    public FuncionarioBancoService(FuncionarioBancoRepository repository, FuncionarioBancoMapper mapper,
            AuthenticationManager authenticationManager, JwtService jwtService, UsuarioService usuarioService) {
        super(repository, mapper, authenticationManager, jwtService, usuarioService);
    }

    @Override
    public FuncionarioBancoDTO getCurrentUser() {
        return mapper.toDTO(usuarioService.getCurrentFuncionarioBanco());
    }
}
