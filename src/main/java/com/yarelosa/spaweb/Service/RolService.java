package com.yarelosa.spaweb.Service;

import com.yarelosa.spaweb.Entity.Rol;
import com.yarelosa.spaweb.Repository.RolRepository;
import org.springframework.stereotype.Service;

@Service
public class RolService {
    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public Rol getRol(String name) {
        return rolRepository.findByNombreEquals(name);
    }
}
