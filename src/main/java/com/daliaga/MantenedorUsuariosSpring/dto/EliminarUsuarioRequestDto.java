package com.daliaga.MantenedorUsuariosSpring.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class EliminarUsuarioRequestDto {

    private Long Id;
    private String email;
    private String password;
    private String repassword;
}
