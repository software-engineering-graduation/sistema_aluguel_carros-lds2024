package com.lds.aluguel_carros.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import com.lds.aluguel_carros.config.JwtService;
import com.lds.aluguel_carros.dto.ClienteDTO;
import com.lds.aluguel_carros.dto.create.ClienteCreateDTO;
import com.lds.aluguel_carros.entity.Cliente;
import com.lds.aluguel_carros.mappers.ClienteMapper;
import com.lds.aluguel_carros.repository.ClienteRepository;

@Service
public class ClienteService extends AbstractUsuarioService<Cliente, ClienteCreateDTO, ClienteDTO> {
    public ClienteService(ClienteRepository repository, ClienteMapper mapper, AuthenticationManager authenticationManager, JwtService jwtService) {
        super(repository, mapper, authenticationManager, jwtService);
    }
}
