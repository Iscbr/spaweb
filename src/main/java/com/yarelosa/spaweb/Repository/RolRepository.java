package com.yarelosa.spaweb.Repository;

import com.yarelosa.spaweb.Entity.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {
    Rol findByNombreContains(String name);
    Rol findByNombreEquals(String rol);
}

