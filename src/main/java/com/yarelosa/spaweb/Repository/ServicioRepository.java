package com.yarelosa.spaweb.Repository;

import com.yarelosa.spaweb.Entity.Servicio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends CrudRepository<Servicio, Integer> {
    List<Servicio> getAllByActivoTrue();

}
