package com.lds.aluguel_carros.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Login {
    private String email;
    private String senha;
}
