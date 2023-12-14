package com.iftm.projetofinal.app.domain;

import lombok.Data;

@Data
public class Cenario {
    private int cod_cenario;
    private String caracteristicas;
    private int qtde_min_pontos;

    public Cenario() {
    }

    public Cenario(int cod_cenario, String caracteristicas, int qtde_min_pontos) {
        this.cod_cenario = cod_cenario;
        this.caracteristicas = caracteristicas;
        this.qtde_min_pontos = qtde_min_pontos;
    }
}
