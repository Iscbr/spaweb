package com.yarelosa.spaweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spaweb")
public class AdminController {

    @GetMapping({"/index", "/home", ""})
    public String index(Model model) {
        model.addAttribute("title", "Home");
        model.addAttribute("name", "Principal of web application");
        return "/admin/index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "/cliente/form";
    }

    @GetMapping("/personal")
    public String personal(Model model) {
        return "/admin/personal";
    }

    @GetMapping("/perfil")
    public String perfil(Model model) {
        return "/admin/pages-profile";
    }

    /**
     * Este método tiene que mostrar TODAS las citas de TODOS los empleados
     */
    @GetMapping("/citas")
    public String citas(Model model) {
        return "/admin/citasPro";
    }

    @GetMapping("/adminPer")
    public String agregar(Model model){
        return "/admin/adminPer";
    }
}
