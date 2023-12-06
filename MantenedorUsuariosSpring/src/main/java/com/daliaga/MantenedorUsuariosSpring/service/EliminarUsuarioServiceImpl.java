package com.daliaga.MantenedorUsuariosSpring.service;

import com.daliaga.MantenedorUsuariosSpring.Constantes.Constantes;
import com.daliaga.MantenedorUsuariosSpring.dto.EliminarUsuarioRequestDto;
import com.daliaga.MantenedorUsuariosSpring.dto.EliminarUsuarioResponseDto;
import com.daliaga.MantenedorUsuariosSpring.exceptions.MantenedorError;
import com.daliaga.MantenedorUsuariosSpring.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class EliminarUsuarioServiceImpl implements EliminarUsuarioService{

    @Autowired
    public UsuarioRepository usuarioRepository;

    @Override
    public EliminarUsuarioResponseDto eliminarUsuario(EliminarUsuarioRequestDto request) throws MantenedorError{
        log.info("[EliminarUsuarioService][eliminarUsuario][INI] "+ request);
        EliminarUsuarioResponseDto eliminarUsuarioResponseDto = EliminarUsuarioResponseDto.builder().build();
        try{
            if (!request.getPassword().equals(request.getRepassword())){
                throw new MantenedorError(HttpStatus.BAD_REQUEST, Constantes.VALIDACION_PASSWORD_DIF);
            }
            if (usuarioRepository.findById(request.getId()).isPresent()){
                usuarioRepository.deleteById(request.getId());
            }else{
                throw new MantenedorError(HttpStatus.NO_CONTENT, Constantes.ERROR_USUARIO_NO_ENCONTRADO);
            }
            eliminarUsuarioResponseDto.setEmail(request.getEmail());
            eliminarUsuarioResponseDto.setMensaje(Constantes.USURIO_ELIMINADO);
            log.info("[EliminarUsuarioService][eliminarUsuario][FIN_OK] "+ eliminarUsuarioResponseDto);
            return eliminarUsuarioResponseDto;
        }catch(Exception e){
            throw new MantenedorError(HttpStatus.CONFLICT, Constantes.ERROR_ELIMINAR_USUARIO);
        }
    }

}
