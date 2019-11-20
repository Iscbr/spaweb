package com.yarelosa.spaweb.Service;

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

    /*@Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario user = this.usuarioRepository.findByUsername(username);

        if (user == null) throw new UsernameNotFoundException("No se ha encontrado el usuario : " + username);

        List<GrantedAuthority> authorities = user
                .getRoles()
                .stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
                .collect(Collectors.toList());

        return new User(user.getUsername(),
                user.getPassword(),
                user.getActivo(),
                true,
                true,
                true,
                authorities);
    }*/

    public List<Usuario> getAllUsers() {
        return this.usuarioRepository.getAllByActivoTrue();
    }

    public Usuario saveUser(Usuario usuario) throws Exception {
        return this.usuarioRepository.save(usuario);
    }

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
