package com.daliaga.MantenedorUsuariosSpring.service;

import com.daliaga.MantenedorUsuariosSpring.dto.EliminarUsuarioRequestDto;
import com.daliaga.MantenedorUsuariosSpring.dto.EliminarUsuarioResponseDto;
import com.daliaga.MantenedorUsuariosSpring.exceptions.MantenedorError;

public interface EliminarUsuarioService {
    public EliminarUsuarioResponseDto eliminarUsuario(EliminarUsuarioRequestDto request) throws MantenedorError;
}
