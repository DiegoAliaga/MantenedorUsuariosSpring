package com.daliaga.MantenedorUsuariosSpring.service;

import com.daliaga.MantenedorUsuariosSpring.Constantes.Constantes;
import com.daliaga.MantenedorUsuariosSpring.dto.ListarUsuariosResponseDto;
import com.daliaga.MantenedorUsuariosSpring.dto.UsuarioDto;
import com.daliaga.MantenedorUsuariosSpring.exceptions.MantenedorError;
import com.daliaga.MantenedorUsuariosSpring.model.Usuario;
import com.daliaga.MantenedorUsuariosSpring.repository.UsuarioRepository;
import com.daliaga.MantenedorUsuariosSpring.util.Utilitarios;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class ListarUsuariosServiceImpl implements ListarUsuariosService {

    @Autowired
    public UsuarioRepository usuarioRepository;
    @Override
    public ListarUsuariosResponseDto listarUsuarios() throws MantenedorError{
        List<Usuario> usuarios;
        ListarUsuariosResponseDto listarUsuariosResponseDto = ListarUsuariosResponseDto.builder().build();
        try{
            if (!usuarioRepository.findAll().isEmpty()){
                usuarios = usuarioRepository.findAll();
            }else{
                throw new MantenedorError(HttpStatus.NOT_FOUND, Constantes.NO_EXISTEN_USUARIOS);
            }
            List<UsuarioDto> usuariosRegistrados = new ArrayList<>();
            for (Usuario usuario: usuarios){
                UsuarioDto usuarioDto = new UsuarioDto();
                usuarioDto.setId(usuario.getId());
                usuarioDto.setEmail(usuario.getEmail());
                usuarioDto.setPhones(Utilitarios.agregarTelefonosDto(usuario.getPhones()));
                usuarioDto.setPassword(Constantes.PASSWORD);
                usuarioDto.setName(usuario.getName());
                usuariosRegistrados.add(usuarioDto);
            }
            listarUsuariosResponseDto.setUsuarios(usuariosRegistrados);
            log.info("[ListarUsuariosService][listarUsuarios][FIN_OK] "+ listarUsuariosResponseDto);
            return listarUsuariosResponseDto;
        }catch(Exception e){
            throw new MantenedorError(HttpStatus.CONFLICT,Constantes.ERROR_LISTAR_USUARIOS);
        }
    }
}
