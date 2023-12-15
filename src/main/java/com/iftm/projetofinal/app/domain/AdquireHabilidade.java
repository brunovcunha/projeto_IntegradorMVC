package com.iftm.projetofinal.app.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdquireHabilidade {
    private Long cod_jogador;
    private Long cod_poder;
}
