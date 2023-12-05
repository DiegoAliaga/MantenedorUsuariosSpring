package com.daliaga.MantenedorUsuariosSpring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorDto {
    private HttpStatus status;
    private String mensaje;


    public String getMensaje(){return mensaje;}
    public HttpStatus getStatus(){return status;}
}
