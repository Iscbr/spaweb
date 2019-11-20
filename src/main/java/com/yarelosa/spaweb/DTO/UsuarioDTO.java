package com.yarelosa.spaweb.DTO;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UsuarioDTO {

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellidoPaterno;

    @NotEmpty
    private String apellidoMaterno;

    @NotEmpty
    private String username;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    private Boolean activo;
}
