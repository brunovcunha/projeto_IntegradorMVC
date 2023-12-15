package com.iftm.projetofinal.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cenario {
    private Long cod_cenario;
    private String caracteristicas;
    private int pontos_necessarios;
}
