package com.daliaga.MantenedorUsuariosSpring.dto;

import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioDto {

    private Long id;
    private String name;
    private String email;
    private String password;
    private List<TelefonoDto> phones;

}
