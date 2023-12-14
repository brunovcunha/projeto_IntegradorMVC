package com.iftm.projetofinal.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iftm.projetofinal.app.dao.GameDao;

@Controller
public class GameController {
    
    @Autowired
    private GameDao dao;

    @GetMapping("")
    public String index() {
        return "login";
    }

    @GetMapping("index")
    public ModelAndView menuPrincipal() {
        ModelAndView mv = new ModelAndView("menu");
        mv.addObject("usuario", null);
        return mv;
    }
    
}