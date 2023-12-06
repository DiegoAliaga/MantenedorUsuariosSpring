package MantenedorUsuariosSpring.service

import com.daliaga.MantenedorUsuariosSpring.config.ApplicationConfig
import com.daliaga.MantenedorUsuariosSpring.dto.ActualizarUsuarioRequestDto
import com.daliaga.MantenedorUsuariosSpring.dto.ActualizarUsuarioResponseDto
import com.daliaga.MantenedorUsuariosSpring.dto.TelefonoDto
import com.daliaga.MantenedorUsuariosSpring.service.ActualizarUsuariosService
import com.daliaga.MantenedorUsuariosSpring.util.Utilitarios
import spock.lang.Specification

class ActualizarUsuariosServiceTest extends Specification{
    ActualizarUsuariosService actualizarUsuariosService
    ApplicationConfig config
    Utilitarios utilitarios

    void setup(){
        config = new ApplicationConfig()
        config.getRegex().setValidacionCorreo("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$")
        config.getRegex().setValidacionPass("'^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}\$'")
        utilitarios = Mock()
    }

    def "Invoca a la clase service para actualizar un usuario resultado OK"(){
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
                .repassword("w3Unpocodet0d1").phones(telefonos)
        when: "se invoca el metodo para actualizar usuario"
        def result = actualizarUsuariosService.actualizarUsuario(actualizarUsuarioRequestDto)
        then: "se retorna respuesta"
        result != null
    }
}
