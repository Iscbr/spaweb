package com.yarelosa.spaweb.Controller;

import com.yarelosa.spaweb.Entity.Cita;
import com.yarelosa.spaweb.Entity.Usuario;
import com.yarelosa.spaweb.Service.CitaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/spaweb")
public class AdminController {

    private final CitaService citaService;

    public AdminController(CitaService citaService) {
        this.citaService = citaService;
    }

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
        List<Cita> citas = citaService.getAll();
        model.addAttribute("citas", citas);
        return "/admin/citasPro";
    }

    @PostMapping("/adminPer")
    public String crearUser(Map<String, Object> model){

        Usuario usuario = new Usuario();
        model.put("usuario", usuario);
        model.put("titulo", "formulario del usuario");
        return "admin/adminPer";
    }
}
