package com.iftm.projetofinal.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.iftm.projetofinal.app.domain.AdquirePoder;

@Component
public class AdquirePoderDao {
    @Autowired
    JdbcTemplate data;

    public List<AdquirePoder> getAdquirePoder(){
        String sql = "SELECT * FROM adquire_poder";

        return data.query(sql, (rs, rowNum) -> new AdquirePoder(
            rs.getLong("cod_jogador"),
            rs.getLong("cod_poder")
        ));
    }

    public void inserirAdquirePoder(Long cod_jogador, Long cod_poder) {
        String sql = "INSERT INTO adquire_poder (cod_jogador, cod_poder) VALUES (?, ?)";
        data.update(sql, cod_jogador, cod_poder);
    }

    public void updateAdquirePoder(Long cod_jogador, Long cod_poder) {
        String sql = "UPDATE adquire_poder SET cod_jogador = ?, cod_poder = ? WHERE cod_jogador = ? AND cod_poder = ?";
        data.update(sql, cod_jogador, cod_poder, cod_jogador, cod_poder);
    }

    public void deleteAdquirePoder(Long cod_jogador, Long cod_poder) {
        String sql = "DELETE FROM adquire_poder WHERE cod_jogador = ? AND cod_poder = ?";
        data.update(sql, cod_jogador, cod_poder);
    }
}
