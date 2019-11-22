package com.yarelosa.spaweb.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.yarelosa.spaweb.com.yarelosa.spaweb.Util.Views;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {

    @Id
    @Column(name = "usuario_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({Views.UsuarioView.class})
    private Integer id;

    @Column(name = "usuario_nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "usuario_apellido_paterno", length = 50, nullable = false)
    private String apellidoPaterno;

    @Column(name = "usuario_apellido_materno", length = 50, nullable = false)
    private String apellidoMaterno;

    @Column(name = "usuario_email", length = 50, nullable = false)
    @NotBlank(message = "El email no puede estar vacio")
    private String email;

    @Column(name = "usuario_password", length = 100, nullable = false)
    @NotBlank(message = "La contraseña no puede estar vacia")
    private String password;

    @Column(name = "usuario_username", length =25, nullable = false)
    private String username;

    @Column(name = "usuario_activo")
    private Boolean activo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuario_rol",
            joinColumns = { @JoinColumn(name = "usuario_id") },
            inverseJoinColumns = { @JoinColumn(name = "rol_id") })
    @ToString.Exclude
    private List<Rol> roles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuario_servicio",
            joinColumns = { @JoinColumn(name = "usuario_id") },
            inverseJoinColumns = { @JoinColumn(name = "servicio_id") })
    @JsonManagedReference
    @ToString.Exclude
    private List<Servicio> servicios;
}
