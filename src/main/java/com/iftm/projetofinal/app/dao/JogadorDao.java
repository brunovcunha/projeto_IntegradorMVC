package com.iftm.projetofinal.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.iftm.projetofinal.app.domain.Jogador;

@Component
public class JogadorDao {

    @Autowired
    JdbcTemplate database;

    public List<Jogador> getJogadores() {
        String sql = "select * from jogador";

        return database.query(sql, (res, rowNum) -> {
            return new Jogador(
                    res.getLong("cod_jogador"),
                    res.getString("apelido"),
                    res.getString("email"),
                    res.getDate("data_nasc"),
                    res.getInt("pontuacao"));
        });
    }

    public List<Jogador> getJogador(String apelido) {
        String sql = "select * from jogador where lower(apelido) like ?";

        return database.query(sql,
                new BeanPropertyRowMapper<>(Jogador.class),
                new Object[] { "%" + apelido + "%" });

    }

    public Jogador getJogador(Long id) {
        String sql = "select * from jogador where id = ?";
        
        List<Jogador> jogadores = database.query(sql,
                new BeanPropertyRowMapper<>(Jogador.class),
                new Object[] { id });

        if (jogadores != null && !jogadores.isEmpty()) {
            return jogadores.get(0);
        } else {
            return null;
        }
    }

    public void cadastrarJogador(Jogador jogador) {
        String sql = "insert into jogador(apelido, email, data_nasc, pontuacao) values (?, ?, ?, 0)";

        database.update(sql, new Object[] {
                jogador.getApelido(),
                jogador.getEmail(),
                jogador.getData_nasc()});
    }
    
    public void atualizarJogador(Jogador jogador) {
        String sql = "update jogador set apelido = ?, email = ?, pontuacao = ? where cod_jogador = ?";

        database.update(sql,
                jogador.getApelido(),
                jogador.getEmail(),
                jogador.getPontuacao(),
                jogador.getCod_jogador());
    }

    public void apagarJogador(Long cod_jogador) {
        String sql = "delete from jogador where cod_jogador = ?";
        database.update(sql, new Object[] { cod_jogador });
    }

}