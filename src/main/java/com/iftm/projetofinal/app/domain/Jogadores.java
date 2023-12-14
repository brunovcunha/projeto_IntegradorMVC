package com.iftm.projetofinal.app.domain;

import java.util.Date;

import lombok.Data;


@Data
public class Jogadores {
    private Long cod_jogador;

    private String nome;
    private String nickname;
    private char sexo;
    private String email;
    private Date dt_nasc;
    private int pontuacao;
    private int moedas;

    public Jogadores() {
    }

    public Jogadores(Long cod_jogador, String nome, String nickname, char sexo, String email, Date dt_nasc, int pontuacao, int moedas) {
        this.cod_jogador = cod_jogador;
        this.nome = nome;
        this.nickname = nickname;
        this.sexo = sexo;
        this.email = email;
        this.dt_nasc = dt_nasc;
        this.pontuacao = pontuacao;
        this.moedas = moedas;
    }
}
