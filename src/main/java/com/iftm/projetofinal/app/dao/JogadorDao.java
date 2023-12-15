package com.iftm.projetofinal.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.iftm.projetofinal.app.domain.Jogadores;


@Component
public class JogadorDao {

    @Autowired
    JdbcTemplate data;

    public List<Jogadores> getJogadores(){
        String sql = "SELECT * FROM jogador";

        return data.query(sql, (rs, rowNum) -> new Jogadores(
            rs.getLong("cod_jogador"),
            rs.getString("nickname"),
            rs.getString("senha"),
            rs.getString("data_nasc"),
            rs.getInt("pontuacao")
        ));
    }

    public List<Jogadores> getJogador(String nickname){
        String sql = "SELECT * FROM jogador WHERE nickname = ?";

        return data.query(sql,
        new BeanPropertyRowMapper<>(Jogadores.class),
        new Object[]{"%"+nickname+"%"});
    }

    public void inserirJogadores(Jogadores jogador) {
        String sql = "INSERT INTO jogador (nickname, senha, data_nasc, pontuacao) VALUES (?, ?, ?, ?)";
        data.update(sql, jogador.getNickname(), jogador.getSenha(), jogador.getData_nasc(),jogador.getPontuacao());
    }

    public void updateJogadores(Jogadores jogador) {
        String sql = "UPDATE jogador SET nickname = ?, senha = ?, data_nasc = ?, pontuacao = ? WHERE cod_jogador = ?";
        data.update(sql, jogador.getNickname(), jogador.getSenha(), jogador.getData_nasc(),jogador.getPontuacao(), jogador.getCod_jogador());
    }

    public void deleteJogadores(Long cod_jogador) {
        String sql = "DELETE FROM jogador WHERE cod_jogador = ?";
        data.update(sql, cod_jogador);
    }
}