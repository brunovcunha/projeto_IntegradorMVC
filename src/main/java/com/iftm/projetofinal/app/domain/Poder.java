package com.iftm.projetofinal.app.domain;

import lombok.Data;

@Data
public class Poder {
    private int cod_poder;
    private String habilidade;

    public Poder() {
    }

    public Poder(int cod_poder, String habilidade) {
        this.cod_poder = cod_poder;
        this.habilidade = habilidade;
    }
}
