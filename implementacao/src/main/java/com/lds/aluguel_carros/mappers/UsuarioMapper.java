package com.lds.aluguel_carros.mappers;

import org.springframework.stereotype.Component;

import com.lds.aluguel_carros.dto.UsuarioDTO;
import com.lds.aluguel_carros.entity.Usuario;

@Component
public class UsuarioMapper {

    public UsuarioMapper() {
    }

    public UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .tipo(usuario.getTipo())
                .build();
    }
}
