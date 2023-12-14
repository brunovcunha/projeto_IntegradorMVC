package com.iftm.projetofinal.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GameDao {

    @Autowired
    JdbcTemplate data;

    public List<Jogadores> getJogadores() {
        String SQL = "select nickname, email from"
    }   

    
}