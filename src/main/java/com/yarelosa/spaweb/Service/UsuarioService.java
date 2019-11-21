package com.yarelosa.spaweb.Service;

import com.yarelosa.spaweb.DTO.UsuarioDTO;
import com.yarelosa.spaweb.Entity.Rol;
import com.yarelosa.spaweb.Entity.Usuario;
import com.yarelosa.spaweb.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAllUsers() {
        return this.usuarioRepository.getAllByActivoTrue();
    }

    /*
    public Usuario saveUser(UsuarioDTO usuarioDTO) {

        Usuario user = new Usuario();
        user.setNombre(usuarioDTO.getNombre());
        user.setEmail(usuarioDTO.getEmail());

        this.usuarioRepository.save(user);

        return user;
    }

     */

    public Usuario getById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public boolean borrarUsuario(Integer id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        Rol rol = usuario.getRoles()
                .stream()
                .filter(rolLambda -> rolLambda.equals("ROLE_ADMIN"))
                .findFirst().orElse(null);

        if (rol == null){
            usuarioRepository.delete(usuario);
            return true;
        }
        return false;
    }

}
