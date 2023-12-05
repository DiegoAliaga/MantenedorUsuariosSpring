package MantenedorUsuariosSpring.controller

import com.daliaga.MantenedorUsuariosSpring.controller.MantenedorUsuariosSpringController
import com.daliaga.MantenedorUsuariosSpring.dto.ActualizarUsuarioRequestDto
import com.daliaga.MantenedorUsuariosSpring.dto.ActualizarUsuarioResponseDto
import com.daliaga.MantenedorUsuariosSpring.dto.TelefonoDto
import com.daliaga.MantenedorUsuariosSpring.service.*
import spock.lang.Specification

class ManetenedorUsuariosControllerTest extends Specification{

    ActualizarUsuariosService actualizarUsuariosService= Stub()
    EliminarUsuarioService eliminarUsuarioService= Stub()
    ListarUsuariosService listarUsuariosService = Stub()
    ListarUsuarioService listarUsuarioService = Stub()
    RegistrarUsuarioService registrarUsuarioService = Stub()
    MantenedorUsuariosSpringController mantenedorUsuariosSpringController = new MantenedorUsuariosSpringController()

    void setup(){
        mantenedorUsuariosSpringController.actualizarUsuariosService = actualizarUsuariosService
        mantenedorUsuariosSpringController.eliminarUsuarioService = eliminarUsuarioService
        mantenedorUsuariosSpringController.listarUsuariosService = listarUsuariosService
        mantenedorUsuariosSpringController.listarUsuarioService = listarUsuarioService
        mantenedorUsuariosSpringController.registrarUsuarioService = registrarUsuarioService
    }

    def "Actualizar Usuario resultado ok"(){
        given: "envian los datos para actualizar el usuario"
        ActualizarUsuarioResponseDto actualizarUsuarioResponseDto = ActualizarUsuarioResponseDto.builder().build()
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
                .repassword("w3Unpocodet0d1").phones(telefonos)
        actualizarUsuariosService.actualizarUsuario(_,_) >> actualizarUsuarioResponseDto
        when: "Se invoca al servicio"
        def respuesta = mantenedorUsuariosSpringController.actualizarUsuario(actualizarUsuarioRequestDto)
        then : "El Servicio Responde OK"
        respuesta != null
        respuesta == actualizarUsuarioResponseDto
    }
}
