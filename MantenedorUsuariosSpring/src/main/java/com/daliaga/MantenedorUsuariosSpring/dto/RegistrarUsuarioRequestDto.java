package com.daliaga.MantenedorUsuariosSpring.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@ToString
public class RegistrarUsuarioRequestDto {
    private String name;
    private String email;
    private String password;
    private List<TelefonoDto> phones;


}
