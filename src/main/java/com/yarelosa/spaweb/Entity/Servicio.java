package com.yarelosa.spaweb.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yarelosa.spaweb.Repository.UsuarioRepository;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "servicios")
@Data
public class Servicio {

    @Id
    @Column(name = "servicio_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "servicio_nombre", length = 50, nullable = false)
    private String servicioNombre;

    @Column ( name = "servicio_descrip", length = 1000, nullable = false)
    private String servicioDesc;

    @Column (name = "servicio_precio", nullable =  false)
    private Float precio;

    @Column (name = "servicio_duracion", nullable = false)
    private Integer duracion;

    @Column (name = "servicio_categoria", nullable = false, length = 100)
    private String servicioCatego;

    @Column (name = "activo", nullable = false)
    private Boolean activo;

    @ManyToMany(mappedBy = "servicios")
    @JsonIgnore
    @ToString.Exclude
    private List<Usuario> users;

}
