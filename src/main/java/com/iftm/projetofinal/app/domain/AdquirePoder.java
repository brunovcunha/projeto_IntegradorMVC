package com.iftm.projetofinal.app.domain;

import java.util.Date;

import lombok.Data;

@Data
public class AdquirePoder {
    private int cod_aquisicao;
    private int cod_jogador;
    private int cod_poder;
    private Date dt_hora_aquisicao;

    public AdquirePoder() {
    }

    public AdquirePoder(int cod_aquisicao, int cod_jogador, int cod_poder, Date dt_hora_aquisicao) {
        this.cod_aquisicao = cod_aquisicao;
        this.cod_jogador = cod_jogador;
        this.cod_poder = cod_poder;
        this.dt_hora_aquisicao = dt_hora_aquisicao;
    }
}
