package com.iftm.projetofinal.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.iftm.projetofinal.app.domain.Partida;

@Component
public class PartidaDao {
    
    @Autowired
    JdbcTemplate data;

    public List<Partida> getPartida(){
        String sql = "SELECT * FROM partida";

        return data.query(sql, (rs, rowNum) -> new Partida(
            rs.getLong("cod_partida"),
            rs.getLong("duracao"),
            rs.getInt("pontos_obtidos"),
            rs.getLong("cod_jogador"),
            rs.getLong("cod_cenario")
        ));
    }

    public List<Partida> getPartida(Long id_partida){
        String sql = "SELECT * FROM partida WHERE id_partida = ?";

        return data.query(sql,
        new BeanPropertyRowMapper<>(Partida.class),
        new Object[]{"%"+id_partida+"%"});
    }

    public void inserirPartida(Partida partida) {
        String sql = "INSERT INTO partida (duracao, pontos_obtidos, cod_jogador, cod_cenario) VALUES (?, ?, ?, ?)";
        data.update(sql, partida.getDuracao(), partida.getPontos_obtidos(), partida.getCod_jogador(), partida.getCod_cenario());
    }

    public void updatePartida(Partida partida) {
        String sql = "UPDATE partida SET duracao = ?, pontos_obtidos = ?, cod_jogador = ?, cod_cenario = ? WHERE id_partida = ?";
        data.update(sql, partida.getDuracao(), partida.getPontos_obtidos(), partida.getCod_jogador(), partida.getCod_cenario(), partida.getId_partida());
    }

    public void deletePartida(Long id_partida) {
        String sql = "DELETE FROM partida WHERE id_partida = ?";
        data.update(sql, id_partida);
    }
}
