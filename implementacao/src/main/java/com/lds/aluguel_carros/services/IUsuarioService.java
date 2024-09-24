package com.lds.aluguel_carros.services;

import org.apache.coyote.BadRequestException;

import com.lds.aluguel_carros.dto.Login;
import com.lds.aluguel_carros.dto.UsuarioDTO;
import com.lds.aluguel_carros.dto.create.UsuarioCreateDTO;
import com.lds.aluguel_carros.entity.Usuario;

public interface IUsuarioService<T extends Usuario, D extends UsuarioCreateDTO, K extends UsuarioDTO> {
    void create(D user) throws BadRequestException;
    String login(Login user);
    K getCurrentUser();
    void delete();
}
