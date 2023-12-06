package com.daliaga.MantenedorUsuariosSpring.service;

import com.daliaga.MantenedorUsuariosSpring.dto.ListarUsuariosResponseDto;
import com.daliaga.MantenedorUsuariosSpring.exceptions.MantenedorError;

public interface ListarUsuariosService {
    public ListarUsuariosResponseDto listarUsuarios() throws MantenedorError;
}
