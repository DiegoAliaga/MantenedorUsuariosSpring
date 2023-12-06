package com.daliaga.MantenedorUsuariosSpring.service;

import com.daliaga.MantenedorUsuariosSpring.dto.ActualizarUsuarioRequestDto;
import com.daliaga.MantenedorUsuariosSpring.dto.ActualizarUsuarioResponseDto;
import com.daliaga.MantenedorUsuariosSpring.exceptions.MantenedorError;

public interface ActualizarUsuariosService {
    public ActualizarUsuarioResponseDto actualizarUsuario(ActualizarUsuarioRequestDto request) throws MantenedorError;
}
