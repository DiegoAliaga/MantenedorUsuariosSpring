package com.daliaga.MantenedorUsuariosSpring.service;

import com.daliaga.MantenedorUsuariosSpring.dto.ListarUsuarioRequestDto;
import com.daliaga.MantenedorUsuariosSpring.dto.ListarUsuarioResponseDto;
import com.daliaga.MantenedorUsuariosSpring.dto.ListarUsuariosResponseDto;
import com.daliaga.MantenedorUsuariosSpring.exceptions.MantenedorError;

public interface ListarUsuarioService {
    public ListarUsuarioResponseDto listarUsuario(ListarUsuarioRequestDto request) throws MantenedorError;
}
