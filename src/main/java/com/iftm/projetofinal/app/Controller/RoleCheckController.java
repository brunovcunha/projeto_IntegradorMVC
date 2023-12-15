package com.iftm.projetofinal.app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoleCheckController {
    @RequestMapping("/admin/gerenciarLogins")
    public String iniciar(Model model) {
        return "gerenciarLogins";
    }
}
