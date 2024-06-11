package com.in28minutes.springboot.infrastructure.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.in28minutes.springboot.core.exception.BadRequestException;
import com.in28minutes.springboot.core.exception.NotFoundException;
import com.in28minutes.springboot.infrastructure.dto.BaseResponseDto;

@RestControllerAdvice
public class HandleException {


    @ExceptionHandler(BadRequestException.class)
    public BaseResponseDto<?> badRequestException(BadRequestException exception) {

        return BaseResponseDto.builder()
            .message(exception.getMessage())
            .code(exception.getCode())
            .result(exception.getLocalizedMessage())
            .build();

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponseDto<?> methodArgumentNotValidException(MethodArgumentNotValidException exception) {

        HashMap<String, String> erros = new HashMap<>();
        exception.getFieldErrors().forEach(error -> erros.put(error.getField(), error.getDefaultMessage()));

        return BaseResponseDto.builder()
            .message("Error Request")
            .code(HttpStatus.BAD_REQUEST.toString())
            .result(erros)
            .build();

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseResponseDto<?> httpMessageNotReadableException(HttpMessageNotReadableException exception) {

        return BaseResponseDto.builder()
            .message("Error Request")
            .code(HttpStatus.BAD_REQUEST.toString())
            .result(exception.getMessage())
            .build();

    }

    @ExceptionHandler(NotFoundException.class)
    public BaseResponseDto<?> notFoundException(NotFoundException exception) {

        return BaseResponseDto.builder()
            .message(exception.getMessage())
            .code(HttpStatus.NOT_FOUND.toString())
            .result(exception.getMessage() + " - " + exception.getCode())
            .build();

    }
    
}
