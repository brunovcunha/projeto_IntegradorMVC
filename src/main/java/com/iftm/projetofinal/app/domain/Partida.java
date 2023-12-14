package com.iftm.projetofinal.app.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Partida {
    private int cod_partida;
    private Date data_hora_inicio;
    private Date data_hora_termino;
    private int pontos_obtidos;
    private int cod_jogador;
    private int cod_cenario;

    public Partida() {
    }

    public Partida(int cod_partida, Date data_hora_inicio, Date data_hora_termino, int pontos_obtidos, int cod_jogador, int cod_cenario) {
        this.cod_partida = cod_partida;
        this.data_hora_inicio = data_hora_inicio;
        this.data_hora_termino = data_hora_termino;
        this.pontos_obtidos = pontos_obtidos;
        this.cod_jogador = cod_jogador;
        this.cod_cenario = cod_cenario;
    }
}
