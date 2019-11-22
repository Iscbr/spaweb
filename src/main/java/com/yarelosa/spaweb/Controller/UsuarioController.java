package com.yarelosa.spaweb.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.yarelosa.spaweb.DTO.UsuarioDTO;
import com.yarelosa.spaweb.Entity.Rol;
import com.yarelosa.spaweb.Entity.Servicio;
import com.yarelosa.spaweb.Entity.Usuario;
import com.yarelosa.spaweb.Repository.RolRepository;
import com.yarelosa.spaweb.Repository.UsuarioRepository;
import com.yarelosa.spaweb.Service.RolService;
import com.yarelosa.spaweb.Service.ServicioService;
import com.yarelosa.spaweb.Service.UsuarioService;
import com.yarelosa.spaweb.com.yarelosa.spaweb.Util.Views;
import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;
    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private RolService rolService;
    private ServicioService servicioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService,
                             UsuarioRepository usuarioRepository,
                             RolRepository rolRepository,
                             RolService rolService,
                             ServicioService servicioService) {

        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.rolService = rolService;
        this.servicioService = servicioService;
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

    @PostMapping ("/agregaPerfil")
    public String guardarUser(@Valid Usuario usuario, BindingResult result, Model model){
        List<Rol> roles = new ArrayList<>();
        List<Servicio> servicios = new ArrayList<>();

        if(result.hasErrors()){
            model.addAttribute("titulo","fallo guardado");
            return "admin/adminPer";
        }

        Usuario user = new Usuario();
        user.setNombre(usuario.getNombre());
        user.setApellidoPaterno(usuario.getApellidoPaterno());
        user.setApellidoMaterno(usuario.getApellidoMaterno());
        user.setEmail(usuario.getEmail());
        user.setUsername(usuario.getUsername());
        user.setPassword(usuario.getPassword());

        try{
            Rol rol = rolService.getRol("ROLE_USER");
            roles.add(rol);
        }catch (Exception e){
            e.printStackTrace();
        }

        user.setRoles(roles);

        try{
            Servicio serv = servicioService.getServiciodefault("default") ;
            servicios.add(serv);
        }catch (Exception e){
            e.printStackTrace();
        }

        model.addAttribute("succesfull", "Perfil agregado exitosamente");
        model.addAttribute("usuario",user);

        this.usuarioRepository.save(user);

        return "redirect:admin/personal";
    }

}
