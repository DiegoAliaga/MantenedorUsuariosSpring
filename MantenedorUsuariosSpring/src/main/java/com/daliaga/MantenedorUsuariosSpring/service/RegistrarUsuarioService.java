package com.daliaga.MantenedorUsuariosSpring.service;

import com.daliaga.MantenedorUsuariosSpring.dto.RegistrarUsuarioRequestDto;
import com.daliaga.MantenedorUsuariosSpring.dto.RegistrarUsuarioResponseDto;
import com.daliaga.MantenedorUsuariosSpring.exceptions.MantenedorError;

public interface RegistrarUsuarioService {
    public RegistrarUsuarioResponseDto registrarUsuario(RegistrarUsuarioRequestDto request) throws MantenedorError;
}
