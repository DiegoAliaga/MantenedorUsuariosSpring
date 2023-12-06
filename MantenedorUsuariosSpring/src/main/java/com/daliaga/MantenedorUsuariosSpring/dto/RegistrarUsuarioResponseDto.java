package com.daliaga.MantenedorUsuariosSpring.dto;

import com.daliaga.MantenedorUsuariosSpring.model.Usuario;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class RegistrarUsuarioResponseDto {
    private Usuario usuario;

}
