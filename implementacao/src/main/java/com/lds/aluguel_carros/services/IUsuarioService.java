package com.lds.aluguel_carros.services;

import com.lds.aluguel_carros.dto.Login;
import com.lds.aluguel_carros.dto.create.UsuarioCreateDTO;
import com.lds.aluguel_carros.entity.Usuario;

public interface IUsuarioService<T extends Usuario, D extends UsuarioCreateDTO> {
    void create(D user);
    String login(Login user);
}
