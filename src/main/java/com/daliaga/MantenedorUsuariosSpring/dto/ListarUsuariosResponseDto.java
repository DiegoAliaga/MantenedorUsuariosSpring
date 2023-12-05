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
public class ListarUsuariosResponseDto {

    private List<UsuarioDto> usuarios;
}
