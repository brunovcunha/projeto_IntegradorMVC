package com.iftm.projetofinal.app.domain;


import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Login {

    @NonNull
    private String usuario;

    @NonNull
    private String senha;

    
}