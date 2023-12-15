package com.iftm.projetofinal.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.iftm.projetofinal.app.domain.Poder;

@Component
public class PoderDao {
    @Autowired
    JdbcTemplate data;

    public List<Poder> getPoder(){
        String sql = "SELECT * FROM poder";

        return data.query(sql, (rs, rowNum) -> new Poder(
            rs.getLong("cod_poder"),
            rs.getString("habilidade"),
            rs.getString("descricao")
        ));
    }

    public List<Poder> getPoder(String nome){
        String sql = "SELECT * FROM poder WHERE nome = ?";

        return data.query(sql,
        new BeanPropertyRowMapper<>(Poder.class),
        new Object[]{"%"+nome+"%"});
    }

    public void inserirPoder(Poder poder) {
        String sql = "INSERT INTO poder (nome, descricao) VALUES (?, ?)";
        data.update(sql, poder.getHabilidade(), poder.getDescricao());
    }

    public void updatePoder(Poder poder) {
        String sql = "UPDATE poder SET nome = ?, descricao = ? WHERE cod_poder = ?";
        data.update(sql, poder.getHabilidade(), poder.getDescricao(), poder.getCod_poder());
    }

    public void deletePoder(Long cod_poder) {
        String sql = "DELETE FROM poder WHERE cod_poder = ?";
        data.update(sql, cod_poder);
    }
}
