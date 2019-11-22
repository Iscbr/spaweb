package com.yarelosa.spaweb.Controller;

import com.yarelosa.spaweb.DTO.CitaDTO;
import com.yarelosa.spaweb.Service.CitaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservas")
@Log4j2
public class CitaController {
    private final CitaService citaService;


    @Autowired
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @PostMapping("/reservar")
    public String reservar(@RequestBody CitaDTO citaDTO, Model model) {

        String folio = citaService.reservar(citaDTO);
        model.addAttribute("filioCita", folio);
        return "/cliente/about";
    }

    @GetMapping("/reservar")
    public String getTemplateReservation(Model model) {
        model.addAttribute("citaDTO", new CitaDTO());

        return "/cliente/reserva";
    }
}
