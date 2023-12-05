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
public class ActualizarUsuarioRequestDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String repassword;
    private List<TelefonoDto> phones;
    private Boolean isActive;
}
