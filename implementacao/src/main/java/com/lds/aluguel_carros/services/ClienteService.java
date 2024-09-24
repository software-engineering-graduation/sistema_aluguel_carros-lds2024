package com.lds.aluguel_carros.services;

import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import com.lds.aluguel_carros.config.JwtService;
import com.lds.aluguel_carros.dto.ClienteDTO;
import com.lds.aluguel_carros.dto.create.ClienteCreateDTO;
import com.lds.aluguel_carros.entity.Cliente;
import com.lds.aluguel_carros.exception.EntityExistsException;
import com.lds.aluguel_carros.mappers.ClienteMapper;
import com.lds.aluguel_carros.repository.ClienteRepository;

import jakarta.validation.ConstraintViolationException;

@Service
public class ClienteService extends AbstractUsuarioService<Cliente, ClienteCreateDTO, ClienteDTO> {    
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository repository, ClienteMapper mapper, AuthenticationManager authenticationManager, JwtService jwtService, UsuarioService usuarioService) {
        super(repository, mapper, authenticationManager, jwtService, usuarioService);
        this.clienteRepository = repository;
    }

    @Override
    public void create(ClienteCreateDTO user) throws BadRequestException {
        Optional<Cliente> userExists = clienteRepository.findByCpf(user.getCpf());
        if (userExists.isPresent()) {
            throw new EntityExistsException("Usuário já cadastrado com o mesmo CPF");
        }
        if(!correctNumberOfRendimentos(user)){
            throw new BadRequestException("É possível cadastrar apenas 3 rendimentos");
        }
        Cliente usuario = mapper.toEntity(user);

        try {
            repository.save(usuario);
        } catch (ConstraintViolationException e){
            logger.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException("Erro ao salvar usuário");
        }
    }

    private boolean correctNumberOfRendimentos(ClienteCreateDTO user) {
        return user.getRendimentos().size() <= 3;
    }

    @Override
    public ClienteDTO getCurrentUser() {
        return mapper.toDTO(usuarioService.getCurrentCliente());
    }
}
