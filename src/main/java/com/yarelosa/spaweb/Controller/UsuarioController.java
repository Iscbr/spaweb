package com.yarelosa.spaweb.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.yarelosa.spaweb.DTO.UsuarioDTO;
import com.yarelosa.spaweb.Entity.Usuario;
import com.yarelosa.spaweb.Repository.UsuarioRepository;
import com.yarelosa.spaweb.Service.UsuarioService;
import com.yarelosa.spaweb.com.yarelosa.spaweb.Util.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, UsuarioRepository usuarioRepository) {

        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
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

    @GetMapping ("/agregaPerfil")
    public String saveUser(@Valid UsuarioDTO usuarioDTO, BindingResult result, Model model){
        if(result.hasErrors()){
            return "admin/personal";
        }

        Usuario user = new Usuario();
        user.setNombre(usuarioDTO.getNombre());
        user.setEmail(usuarioDTO.getEmail());

        this.usuarioRepository.save(user);

        model.addAttribute("succesfull", "Perfil agregado exitosamente");
        return "admin/personal";
    }

}
