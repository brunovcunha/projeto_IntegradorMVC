package com.iftm.projetofinal.app.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.iftm.projetofinal.app.domain.Login;

@Component
public class LoginDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final Logger logger = LoggerFactory.getLogger(LoginDao.class);

    public void salvar(Login login) {
        String sql = "INSERT INTO login (login, senha) VALUES (?, ?)";
        jdbcTemplate.update(sql, login.getLogin(), login.getSenha());
    }

    public Login getLogin(String user) {
        String sql = "SELECT login, senha FROM login WHERE login = ?";
        try {
            Login login = jdbcTemplate.queryForObject(sql,
                (res, rowNum) -> {
                return new Login(
                        res.getString("login"),
                        res.getString("senha"));
                }, new Object[] { user });
                return login;
        } catch (EmptyResultDataAccessException e) {
            logger.info("User not found " + user + " message: " + e);
            return null;
        }
    }
    
}

