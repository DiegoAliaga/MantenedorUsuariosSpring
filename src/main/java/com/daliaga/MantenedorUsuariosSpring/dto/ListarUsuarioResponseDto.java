package com.daliaga.MantenedorUsuariosSpring.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Builder
@Getter
@Setter
@ToString
public class ListarUsuarioResponseDto {
    private Long Id;
    private String email;
    private String nombre;
    private List<TelefonoDto> phones;
    private String created;
    private String modified;
    private String lastLogin;
    private Boolean isActive;
}
