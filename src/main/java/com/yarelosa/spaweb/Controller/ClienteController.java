package com.yarelosa.spaweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ClienteController {

    @GetMapping({"/","/home","index"})
    public String index(Model model){
        model.addAttribute("titulo","Yare&Dany SPA");
        model.addAttribute("descripcion", "Inicio de pagina principal");
        return "/cliente/index";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("titulo", "Acerca de nosotrol");
        model.addAttribute("descripcion", "Pagina de informacion sobre el negocio");
        return "cliente/about";
    }

    @GetMapping("/servicios")
    public String serv(Model model){
        model.addAttribute("titulo", "Nuestros Servicios");
        model.addAttribute("descripcion", "Listado de nuestros servicios");
        return "cliente/servicios";
    }

    @GetMapping("/citas")
    public String cita(Model model){
        model.addAttribute("titulo", "Agenda ahora");
        model.addAttribute("descripcion", "Formulario para agendar");
        return "cliente/citas";
    }


    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("titulo", "Contacto");
        model.addAttribute("descripcion", "Contacta con nosotros");
        return "cliente/contact";
    }

    @GetMapping("/cabello")
    public String cabello(Model model){
        model.addAttribute("titulo", "Servicio");
        model.addAttribute("descripcion", "Pagina de informacion sobre el servicio");
        return "cliente/cabello";
    }

    @GetMapping("/manos")
    public String manos(Model model){
        model.addAttribute("titulo", "Servicio");
        model.addAttribute("descripcion", "Pagina de informacion sobre el servicio");
        return "cliente/manos";
    }

    @GetMapping("/rostro")
    public String rostro(Model model){
        model.addAttribute("titulo", "Servicio");
        model.addAttribute("descripcion", "Pagina de informacion sobre el servicio");
        return "cliente/rostro";
    }

    @GetMapping("/spa")
    public String spa(Model model){
        model.addAttribute("titulo", "Servicio");
        model.addAttribute("descripcion", "Pagina de informacion sobre el servicio");
        return "cliente/spa";
    }

}
