package com.yarelosa.spaweb.Repository;

import com.yarelosa.spaweb.Entity.Cita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends CrudRepository<Cita, Integer> {
}
