package com.daliaga.MantenedorUsuariosSpring.exceptions;

import org.springframework.http.HttpStatus;

public class MantenedorError extends Throwable{
    private HttpStatus status;
    private String mensaje;

    public MantenedorError(HttpStatus status, String mensaje){
        this.status= status;
        this.mensaje= mensaje;
    }

    public HttpStatus getStatus(){return status;}
    public String getMensaje(){return mensaje;}
}
