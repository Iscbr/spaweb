package com.yarelosa.spaweb.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.yarelosa.spaweb.Entity.Usuario;
import com.yarelosa.spaweb.Repository.UsuarioRepository;
import com.yarelosa.spaweb.Service.UsuarioService;
import com.yarelosa.spaweb.com.yarelosa.spaweb.Util.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }



    //sonView(Views.UsuarioView.class)
    @GetMapping("/getAll")
    public String getAllUsers(Model model){
        List<Usuario> users;
        model.addAttribute("titulo", "Listado de Usuarios: ");
        users = usuarioService.getAllUsers();

        String name = users.stream().findFirst().toString();

        model.addAttribute("usuarios",name);
        return "test";
    }
}
