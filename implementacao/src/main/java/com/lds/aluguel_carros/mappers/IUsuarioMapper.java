package com.lds.aluguel_carros.mappers;

import com.lds.aluguel_carros.dto.UsuarioDTO;
import com.lds.aluguel_carros.dto.create.UsuarioCreateDTO;
import com.lds.aluguel_carros.entity.Usuario;

public interface IUsuarioMapper<T extends Usuario, D extends UsuarioCreateDTO, K extends UsuarioDTO> {
    T toEntity(D dto);
}
