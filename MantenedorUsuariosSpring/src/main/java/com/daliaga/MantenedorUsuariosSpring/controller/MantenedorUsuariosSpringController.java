package com.daliaga.MantenedorUsuariosSpring.controller;

import com.daliaga.MantenedorUsuariosSpring.dto.*;
import com.daliaga.MantenedorUsuariosSpring.exceptions.MantenedorError;
import com.daliaga.MantenedorUsuariosSpring.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MantenedorUsuariosSpringController {

    @Autowired
    private ActualizarUsuariosService actualizarUsuariosService;

    @Autowired
    private EliminarUsuarioService eliminarUsuarioService;

    @Autowired
    private ListarUsuarioService listarUsuarioService;

    @Autowired
    private ListarUsuariosService listarUsuariosService;

    @Autowired
    private RegistrarUsuarioService registrarUsuarioService;

    @ApiOperation("Operacion que permite buscar y listar un usuario")
    @PostMapping(value = "/buscarUsuario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ListarUsuarioResponseDto listarUsuario(@RequestBody ListarUsuarioRequestDto request) throws MantenedorError {
        return listarUsuarioService.listarUsuario(request);
    }

    @ApiOperation("Operacion que permite listar todos los usuarios existentes")
    @GetMapping(value = "/listarUsuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    public ListarUsuariosResponseDto listarUsuariosResponseDto() throws MantenedorError{
      return listarUsuariosService.listarUsuarios();
    }

    @ApiOperation("Operacion que permite registrar un usuario")
    @PostMapping(value= "/crearUsuario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RegistrarUsuarioResponseDto registrarUsuario(@RequestBody RegistrarUsuarioRequestDto request) throws MantenedorError{
        return registrarUsuarioService.registrarUsuario(request);
    }

    @ApiOperation("Operacion que permite actualizar los datos de un usuario")
    @PutMapping(value = "/actualizarUsuario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ActualizarUsuarioResponseDto actualizarUsuario(@RequestBody ActualizarUsuarioRequestDto request) throws MantenedorError{
        return actualizarUsuariosService.actualizarUsuario(request);
    }

    @ApiOperation("Operacion que permite eliminar un usuario")
    @DeleteMapping(value = "/eliminarUsuario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EliminarUsuarioResponseDto eliminarUsuario(@RequestBody EliminarUsuarioRequestDto request)throws MantenedorError{
        return eliminarUsuarioService.eliminarUsuario(request);
    }

}
