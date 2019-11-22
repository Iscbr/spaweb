package com.yarelosa.spaweb.Service;

import com.yarelosa.spaweb.DTO.CitaDTO;
import com.yarelosa.spaweb.Entity.Cita;
import com.yarelosa.spaweb.Entity.Servicio;
import com.yarelosa.spaweb.Entity.Usuario;
import com.yarelosa.spaweb.Repository.CitaRepository;
import com.yarelosa.spaweb.Repository.ServicioRepository;
import com.yarelosa.spaweb.Repository.UsuarioRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Log4j2
public class CitaService {
    private final CitaRepository citaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ServicioRepository servicioRepository;

    @Autowired
    public CitaService(CitaRepository citaRepository, UsuarioRepository usuarioRepository, ServicioRepository servicioRepository) {
        this.citaRepository = citaRepository;
        this.usuarioRepository = usuarioRepository;
        this.servicioRepository = servicioRepository;
    }

    public String reservar(CitaDTO citaDTO) {
        Usuario usuario = usuarioRepository.findById(citaDTO.getIdUsuario()).orElse(null);
        Servicio servicio = servicioRepository.findById(citaDTO.getIdServicio()).orElse(null);

        if (usuario == null && servicio == null) return null;

        String folio = String.valueOf(ThreadLocalRandom.current().nextInt(1000000, 5000000));
        Cita cita = new Cita();
        cita.setFolio(folio);
        cita.setHoraEntrada(LocalTime.parse(citaDTO.getHoraReserva()));
        cita.setHoraSalida(LocalTime.parse(citaDTO.getHoraReserva()).plusHours(1));
        cita.setNombreCliente(citaDTO.getNombreUsuario());
        cita.setCorreoCliente(citaDTO.getEmailUsuario());
        cita.setActivo(true);
        cita.setFecha(LocalDate.now());
        cita.setUsuario(usuario);
        cita.setServicio(servicio);
        citaRepository.save(cita);
        return folio;
    }
}
