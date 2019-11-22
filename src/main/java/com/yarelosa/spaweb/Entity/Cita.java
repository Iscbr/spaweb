package com.yarelosa.spaweb.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "citas")
@Data
public class Cita implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "citas_id", nullable = false, unique = true, updatable = false)
    private Integer id;

    @Column(name = "cita_folio", length = 20)
    private String folio;

    @Column(name = "citas_hora_entrada")
    private LocalTime horaEntrada;

    @Column(name = "citas_hora_salida")
    private LocalTime horaSalida;

    @Column(name = "citas_fecha")
    private LocalDate fecha;

    @Column(name = "citas_comentarios", length = 500)
    private String comentarios;

    @Column(name = "citas_nombre_cliente", length = 100)
    private String nombreCliente;

    @Column(name = "citas_correo_cliente", length = 100)
    private String correoCliente;

    @Column(name = "citas_activo")
    private Boolean activo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", folio='" + folio + '\'' +
                ", horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                ", fecha=" + fecha +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", correoCliente='" + correoCliente + '\'' +
                ", activo=" + activo +
                ", usuario=" + usuario.toString() +
                ", servicio=" + servicio.toString() +
                '}';
    }
}
