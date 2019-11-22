package com.yarelosa.spaweb.Entity;

import com.yarelosa.spaweb.Repository.UsuarioRepository;
import lombok.Data;

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
    private String nombre;

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
    private List<Usuario> users;

    @Override
    public String toString() {
        return "Servicio{" +
                "id=" + id +
                ", servicioNombre='" + servicioNombre + '\'' +
                ", servicioDesc='" + servicioDesc + '\'' +
                ", precio=" + precio +
                ", duracion=" + duracion +
                ", servicioCatego='" + servicioCatego + '\'' +
                ", activo=" + activo +
                ", users=" + users +
                '}';
    }
}
