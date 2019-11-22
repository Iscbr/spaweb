package com.yarelosa.spaweb.DTO;

import lombok.Data;

@Data
public class CitaDTO {
    private Integer idUsuario;
    private Integer idServicio;
    private String horaReserva;
    private String nombreUsuario;
    private String emailUsuario;
}
