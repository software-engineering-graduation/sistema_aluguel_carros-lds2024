package com.lds.aluguel_carros.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import com.lds.aluguel_carros.config.JwtService;
import com.lds.aluguel_carros.dto.FuncionarioEmpresaDTO;
import com.lds.aluguel_carros.dto.create.FuncionarioEmpresaCreateDTO;
import com.lds.aluguel_carros.entity.FuncionarioEmpresa;
import com.lds.aluguel_carros.mappers.FuncionarioEmpresaMapper;
import com.lds.aluguel_carros.repository.FuncionarioEmpresaRepository;

@Service
public class FuncionarioEmpresaService
        extends AbstractUsuarioService<FuncionarioEmpresa, FuncionarioEmpresaCreateDTO, FuncionarioEmpresaDTO> {
    public FuncionarioEmpresaService(FuncionarioEmpresaRepository repository, FuncionarioEmpresaMapper mapper,
            AuthenticationManager authenticationManager, JwtService jwtService, UsuarioService usuarioService) {
        super(repository, mapper, authenticationManager, jwtService, usuarioService);
    }

    @Override
    public FuncionarioEmpresaDTO getCurrentUser() {
        return mapper.toDTO(usuarioService.getCurrentFuncionarioEmpresa());
    }
}