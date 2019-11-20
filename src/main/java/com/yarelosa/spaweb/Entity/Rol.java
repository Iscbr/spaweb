package com.yarelosa.spaweb.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "rol")
@Data
public class Rol {

    @Id
    @Column(name = "rol_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rol_nombre", length = 50, nullable = false)
    private String nombre;
}
