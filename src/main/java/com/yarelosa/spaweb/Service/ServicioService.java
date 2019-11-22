package com.yarelosa.spaweb.Service;

import com.yarelosa.spaweb.Entity.Servicio;
import com.yarelosa.spaweb.Repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {

    private ServicioRepository servicioRepository;

    @Autowired
    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public List<Servicio> getAllService() {
        return servicioRepository.getAllByActivoTrue();
    }

}
