package com.yarelosa.spaweb.Controller;

import com.yarelosa.spaweb.DTO.CitaDTO;
import com.yarelosa.spaweb.Entity.Servicio;
import com.yarelosa.spaweb.Entity.Usuario;
import com.yarelosa.spaweb.Service.CitaService;
import com.yarelosa.spaweb.Service.ServicioService;
import com.yarelosa.spaweb.Service.UsuarioService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/")
@Log4j2
public class CitaController {
    private final CitaService citaService;
    private final UsuarioService usuarioService;
    private final ServicioService servicioService;

    @Autowired
    public CitaController(CitaService citaService, UsuarioService usuarioService, ServicioService servicioService) {
        this.citaService = citaService;
        this.usuarioService = usuarioService;
        this.servicioService = servicioService;
    }

    @RequestMapping(value="/reservar", method= RequestMethod.POST)
    public String reservar(@ModelAttribute("citaDTO") CitaDTO citaDTO,Model model) {

        log.info("DTO DESDE EL FORM: " + citaDTO);
        String folio = citaService.reservar(citaDTO);
        log.info("FOLIO GENERADO: " + folio);
        model.addAttribute("filioCita", folio);
        return "/cliente/confirmation";
    }

    @GetMapping("/reservar")
    public String getTemplateReservation(Model model) {
        List<Servicio> servicios = servicioService.getAllService();
        List<Usuario> usuarios = usuarioService.getAllUsers();

        model.addAttribute("servicios", servicios);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("citaDTO", new CitaDTO());
        return "/cliente/citas";
    }

}
