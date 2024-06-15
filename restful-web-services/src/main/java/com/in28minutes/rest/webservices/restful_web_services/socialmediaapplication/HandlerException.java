package com.in28minutes.rest.webservices.restful_web_services.socialmediaapplication;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class HandlerException {
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerUserNotFoundException(UserNotFoundException exception, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(
            LocalDateTime.now(), 
            exception.getMessage(), 
            request.getDescription(false));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception, 
        WebRequest request) {

        HashMap<String, String> erros = new HashMap<>();
        exception.getFieldErrors().forEach(error -> erros.put(error.getField(), error.getDefaultMessage()));
        
        ErrorDetails errorDetails = new ErrorDetails(
            LocalDateTime.now(), 
            erros.toString(), 
            request.getDescription(false));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

}
