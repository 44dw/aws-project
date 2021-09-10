package com.dw.awsproject.config;

import com.dw.awsproject.exception.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class RootExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            EntityNotFoundException.class
    })
    protected ResponseEntity<Object> handleEntityNotFound(RuntimeException ex) {
        return new ResponseEntity<>(ex.getLocalizedMessage(), NOT_FOUND);
    }
}
