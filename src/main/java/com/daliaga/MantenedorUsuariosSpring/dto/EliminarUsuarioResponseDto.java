package com.daliaga.MantenedorUsuariosSpring.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class EliminarUsuarioResponseDto {

    private String mensaje;
    private String email;



}
