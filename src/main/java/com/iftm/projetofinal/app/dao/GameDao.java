package com.iftm.projetofinal.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.iftm.projetofinal.app.domain.Jogadores;

@Component
public class GameDao {

    @Autowired
    JdbcTemplate data;

    public List<Jogadores> getJogadores() {
        String SQL = "select nickname, email from jogador where lower(nickname) like ?";

        return data.query(SQL, new Object[] { "%+ nickname +%" }, new BeanPropertyRowMapper<Jogadores>(Jogadores.class));
    }

    
}