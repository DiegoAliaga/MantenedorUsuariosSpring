package com.daliaga.MantenedorUsuariosSpring.service;

import com.daliaga.MantenedorUsuariosSpring.Constantes.Constantes;
import com.daliaga.MantenedorUsuariosSpring.config.ApplicationConfig;
import com.daliaga.MantenedorUsuariosSpring.dto.RegistrarUsuarioRequestDto;
import com.daliaga.MantenedorUsuariosSpring.dto.RegistrarUsuarioResponseDto;
import com.daliaga.MantenedorUsuariosSpring.exceptions.MantenedorError;
import com.daliaga.MantenedorUsuariosSpring.model.Usuario;
import com.daliaga.MantenedorUsuariosSpring.repository.UsuarioRepository;
import com.daliaga.MantenedorUsuariosSpring.util.Utilitarios;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
@RequiredArgsConstructor
public class RegistrarUsuarioServiceImpl implements RegistrarUsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    private final ApplicationConfig config;


    @Override
    public RegistrarUsuarioResponseDto registrarUsuario(RegistrarUsuarioRequestDto request) throws MantenedorError {
        log.info("[RegistrarUsuarioService][registrarUsuario][INI] "+ request);
        RegistrarUsuarioResponseDto registrarUsuarioResponseDto = RegistrarUsuarioResponseDto.builder().build();
        try{
            if (!request.getEmail().matches(config.getRegex().getValidacionCorreo())) {
                throw new MantenedorError(HttpStatus.BAD_REQUEST, Constantes.VALIDACION_EMAIL);
            }
            if (!request.getPassword().matches(config.getRegex().getValidacionPass())){
                throw new MantenedorError(HttpStatus.BAD_REQUEST, Constantes.VALIDACION_PASSWORD);
            }
            Usuario usuario = new Usuario();
            usuario.setEmail(request.getEmail());
            usuario.setName(request.getName());
            usuario.setPassword(request.getPassword());
            usuario.setPhones(Utilitarios.agregarTelefonos(request.getPhones()));
            String fecha = Utilitarios.obtenerFechaActual();
            usuario.setCreated(fecha);
            usuario.setModified(fecha);
            usuario.setLastLogin(fecha);
            usuario.setToken(UUID.randomUUID().toString());
            usuario.setIsActive(true);
            usuarioRepository.save(usuario);

            registrarUsuarioResponseDto.setUsuario(usuario);

            log.info("[RegistrarUsuarioService][registrarUsuario][FIN_OK] "+ registrarUsuarioResponseDto);
            return registrarUsuarioResponseDto;
        }catch (Exception e){
            throw new MantenedorError(HttpStatus.CONFLICT, Constantes.ERROR_CREAR_USUARIO);
        }
    }

}
