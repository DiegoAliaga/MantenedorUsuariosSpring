package com.daliaga.MantenedorUsuariosSpring.service;

import com.daliaga.MantenedorUsuariosSpring.Constantes.Constantes;
import com.daliaga.MantenedorUsuariosSpring.dto.ListarUsuarioRequestDto;
import com.daliaga.MantenedorUsuariosSpring.dto.ListarUsuarioResponseDto;
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
public class ListarUsuarioServiceImpl implements ListarUsuarioService{

    @Autowired
    public UsuarioRepository usuarioRepository;

    @Override
    public ListarUsuarioResponseDto listarUsuario(ListarUsuarioRequestDto request) throws MantenedorError {
        log.info("[ListarUsuarioService][listarUsuario][INI] "+ request);
        ListarUsuarioResponseDto listarUsuarioResponseDto = ListarUsuarioResponseDto.builder().build();
        Usuario usuario;
        try{
            if (!usuarioRepository.findById(request.getId()).isPresent()){
                throw new MantenedorError(HttpStatus.NOT_FOUND, Constantes.ERROR_USUARIO_NO_ENCONTRADO);
            }
            usuario = usuarioRepository.findById(request.getId()).orElseThrow();
            listarUsuarioResponseDto.setId(usuario.getId());
            listarUsuarioResponseDto.setEmail(usuario.getEmail());
            listarUsuarioResponseDto.setCreated(usuario.getCreated());
            listarUsuarioResponseDto.setModified(usuario.getModified());
            listarUsuarioResponseDto.setLastLogin(Utilitarios.obtenerFechaActual());
            listarUsuarioResponseDto.setIsActive(usuario.getIsActive());
            listarUsuarioResponseDto.setNombre(usuario.getName());
            listarUsuarioResponseDto.setPhones(Utilitarios.agregarTelefonosDto(usuario.getPhones()));
            log.info("[ListarUsuarioService][listarUsuario][FIN_OK] "+ listarUsuarioResponseDto);
            return listarUsuarioResponseDto;
        }catch(Exception e){
            throw new MantenedorError(HttpStatus.CONFLICT, Constantes.ERROR_ENCONTRAR_USUARIO);
        }
    }
}
