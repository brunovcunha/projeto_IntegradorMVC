package com.iftm.projetofinal.app.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.iftm.projetofinal.app.DTO.MenuItem;
import com.iftm.projetofinal.app.domain.Role;

@Controller
public class MenuController {

    private Logger logger = LoggerFactory.getLogger(MenuController.class);

    @RequestMapping("menu")
    public String getMenus(Model model, List<Role> roles) {
        logger.info("Processando solicitação para /menu");

        MenuItem contatos = new MenuItem("/cadastro", "Jogador");
        MenuItem gerenciarLogins = new MenuItem("/admin/listagem", "Gerenciar Logins");
        Set<MenuItem> itens = new HashSet<>();

        for (Role role : roles) {
            if ("ADMIN".equals(role.getNome())) {
                itens.add(contatos);
                itens.add(gerenciarLogins);
            } else if ("USER".equals(role.getNome())) {
                itens.add(contatos);
            }
        }

        model.addAttribute("menuItems", itens);
        logger.info("Menus gerados com sucesso. Total de itens: {}", itens.size());

        return "menu";
    }
}
