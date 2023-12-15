package com.iftm.projetofinal.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partida {
    private Long id_partida;
    private Long duracao;
    private int pontos_obtidos;
    private Long jogador;
    private Long cenario;
}
