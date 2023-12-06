package com.daliaga.MantenedorUsuariosSpring.exceptions;

import com.daliaga.MantenedorUsuariosSpring.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler {
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ErrorDto> badRequestError(MantenedorError err){
        ErrorDto errorDto= new ErrorDto(err.getStatus(),err.getMensaje());
        return new ResponseEntity<ErrorDto>(errorDto,errorDto.getStatus());
    }
}
