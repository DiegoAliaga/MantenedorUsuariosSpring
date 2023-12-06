package com.daliaga.MantenedorUsuariosSpring.service

import com.daliaga.MantenedorUsuariosSpring.config.ApplicationConfig
import com.daliaga.MantenedorUsuariosSpring.dto.ActualizarUsuarioRequestDto
import com.daliaga.MantenedorUsuariosSpring.dto.ActualizarUsuarioResponseDto
import com.daliaga.MantenedorUsuariosSpring.dto.TelefonoDto
import com.daliaga.MantenedorUsuariosSpring.exceptions.MantenedorError
import com.daliaga.MantenedorUsuariosSpring.repository.UsuarioRepository
import com.daliaga.MantenedorUsuariosSpring.service.ActualizarUsuariosService
import com.daliaga.MantenedorUsuariosSpring.util.Utilitarios
import spock.lang.Specification

class ActualizarUsuariosServiceTest extends Specification{
    ActualizarUsuariosService actualizarUsuariosService
    ApplicationConfig config
    Utilitarios utilitarios
    UsuarioRepository usuarioRepository

    void setup(){
        config = new ApplicationConfig()
        utilitarios = Mock()
        usuarioRepository = Mock()

        this.actualizarUsuariosService = new ActualizarUsuariosServiceImpl(
                config
        )
    }

    def "Invoca a la clase service para actualizar Mantenedor Exception"(){
        given: "se recibe una solicitud de actualizar"
        List<TelefonoDto> telefonos= new ArrayList<>()
        TelefonoDto telefono = TelefonoDto.builder()
                .number("123")
                .cityCode("2")
                .contryCode("32")
                .build()
        telefonos.add(telefono)
        ActualizarUsuarioRequestDto actualizarUsuarioRequestDto=ActualizarUsuarioRequestDto.builder()
                .id(1)
                .name("asd")
                .email("aa@aa.cl")
                .isActive(true)
                .password("w3Unpocodet0d1")
                .repassword("w3Unpocodet0d1")
                .phones(telefonos)
                .build()
        when: "se invoca el metodo para actualizar usuario"
        def result = actualizarUsuariosService.actualizarUsuario(actualizarUsuarioRequestDto)
        then: "se retorna respuesta"
        thrown(MantenedorError)
    }
}
