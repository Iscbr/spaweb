package com.yarelosa.spaweb.Repository;

import com.yarelosa.spaweb.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    List<Usuario> getAllByActivoTrue();

    List<Usuario> getAllByActivoFalseAndActivoTrue();

    Usuario findByActivoTrueAndUsername(String username);

    Usuario findByUsername(String username);

    Usuario getAllById(Integer id);
}
