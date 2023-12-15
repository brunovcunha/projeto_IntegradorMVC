package com.iftm.projetofinal.app.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Poder {
    private Long cod_poder;
    private String habilidade;
    private String descricao;
}
