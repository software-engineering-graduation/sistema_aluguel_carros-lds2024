package com.lds.aluguel_carros.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lds.aluguel_carros.entity.Cliente;
import com.lds.aluguel_carros.entity.FuncionarioBanco;
import com.lds.aluguel_carros.entity.FuncionarioEmpresa;
import com.lds.aluguel_carros.entity.Usuario;
import com.lds.aluguel_carros.repository.ClienteRepository;
import com.lds.aluguel_carros.repository.FuncionarioBancoRepository;
import com.lds.aluguel_carros.repository.FuncionarioEmpresaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final ClienteRepository clienteRepository;
    private final FuncionarioBancoRepository funcionarioBancoRepository;
    private final FuncionarioEmpresaRepository funcionarioEmpresaRepository;

    public Usuario loadUserByUsername(String email) {
        Cliente cliente;
        FuncionarioBanco funcionarioBanco;
        FuncionarioEmpresa funcionarioEmpresa;

        Optional<Cliente> clienteOptional = clienteRepository.findByEmail(email);
        if (clienteOptional.isPresent()) {
            cliente = clienteOptional.get();
            return cliente;
        }

        Optional<FuncionarioBanco> funcionarioBancoOptional = funcionarioBancoRepository.findByEmail(email);
        if (funcionarioBancoOptional.isPresent()) {
            funcionarioBanco = funcionarioBancoOptional.get();
            return funcionarioBanco;
        }

        Optional<FuncionarioEmpresa> funcionarioEmpresaOptional = funcionarioEmpresaRepository.findByEmail(email);
        if (funcionarioEmpresaOptional.isPresent()) {
            funcionarioEmpresa = funcionarioEmpresaOptional.get();
            return funcionarioEmpresa;
        }

        throw new UsernameNotFoundException("Usuário não encontrado");
    }
}