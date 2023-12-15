package com.iftm.projetofinal.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.iftm.projetofinal.app.domain.Cenario;
import com.iftm.projetofinal.app.domain.Poder;

@Component
public class CenarioDao {
    @Autowired
    JdbcTemplate data;

    public List<Cenario> getCenario(){
        String sql = "SELECT * FROM cenario";

        return data.query(sql, (rs, rowNum) -> new Cenario(
            rs.getLong("cod_cenario"),
            rs.getString("caracteristicas"),
            rs.getInt("pontos_necessarios")
        ));
    }

    public List<Cenario> getCenario(String caracteristicas){
        String sql = "SELECT * FROM poder WHERE caracteristicas = ?";

        return data.query(sql,
        new BeanPropertyRowMapper<>(Cenario.class),
        new Object[]{"%"+caracteristicas+"%"});
    }

    public void inserirCenario(Cenario cenario) {
        String sql = "INSERT INTO cenario (caracteristicas, pontos_necessarios) VALUES (?, ?)";
        data.update(sql, cenario.getCaracteristicas(), cenario.getPontos_necessarios());
    }

    public void updateCenario(Cenario cenario) {
        String sql = "UPDATE cenario SET caracteristicas = ?, pontos_necessarios = ? WHERE cod_cenario = ?";
        data.update(sql, cenario.getCaracteristicas(), cenario.getPontos_necessarios(), cenario.getCod_cenario());
    }

    public void deleteCenario(Long cod_cenario) {
        String sql = "DELETE FROM cenario WHERE cod_cenario = ?";
        data.update(sql, cod_cenario);
    }
}
