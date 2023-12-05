package com.daliaga.MantenedorUsuariosSpring.service;

import com.daliaga.MantenedorUsuariosSpring.Constantes.Constantes;
import com.daliaga.MantenedorUsuariosSpring.config.ApplicationConfig;
import com.daliaga.MantenedorUsuariosSpring.dto.ActualizarUsuarioRequestDto;
import com.daliaga.MantenedorUsuariosSpring.dto.ActualizarUsuarioResponseDto;
import com.daliaga.MantenedorUsuariosSpring.exceptions.MantenedorError;
import com.daliaga.MantenedorUsuariosSpring.model.Usuario;
import com.daliaga.MantenedorUsuariosSpring.repository.UsuarioRepository;
import com.daliaga.MantenedorUsuariosSpring.util.Utilitarios;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class ActualizarUsuariosServiceImpl implements ActualizarUsuariosService{

    @Autowired
    public UsuarioRepository usuarioRepository;
    private final ApplicationConfig config;
    @Override
    public ActualizarUsuarioResponseDto actualizarUsuario(ActualizarUsuarioRequestDto request) throws MantenedorError {
        log.info("[ActualizarUsuariosService][actualizarUsuario][INI] "+ request);
        ActualizarUsuarioResponseDto actualizarUsuarioResponseDto = ActualizarUsuarioResponseDto.builder().build();
        try{
            Usuario usuario = usuarioRepository.findById(request.getId()).orElseThrow();
            if (!request.getEmail().matches(config.getRegex().getValidacionCorreo())){
                throw new MantenedorError(HttpStatus.BAD_REQUEST, Constantes.VALIDACION_EMAIL);
            }
            if (!request.getPassword().matches(config.getRegex().getValidacionPass())){
                throw new MantenedorError(HttpStatus.BAD_REQUEST,Constantes.VALIDACION_PASSWORD);
            }
            if (!request.getPassword().equals(request.getRepassword())){
                throw new MantenedorError(HttpStatus.BAD_REQUEST,Constantes.VALIDACION_PASSWORD_DIF);
            }
            usuario.setName(request.getName());
            usuario.setEmail(request.getEmail());
            usuario.setPhones(Utilitarios.agregarTelefonos(request.getPhones()));
            String fecha = Utilitarios.obtenerFechaActual();
            usuario.setCreated(usuario.getCreated());
            usuario.setModified(fecha);
            usuario.setLastLogin(fecha);
            usuario.setIsActive(request.getIsActive());
            usuarioRepository.save(usuario);

            actualizarUsuarioResponseDto.setId(request.getId().toString());
            actualizarUsuarioResponseDto.setUsuario(usuario);
            log.info("[ActualizarUsuariosService][actualizarUsuario][FIN_OK] "+ actualizarUsuarioResponseDto);
            return actualizarUsuarioResponseDto;
        }catch (Exception e){
            throw new MantenedorError(HttpStatus.CONFLICT, Constantes.ERROR_ACTUALIZACION);
        }

    }
}
