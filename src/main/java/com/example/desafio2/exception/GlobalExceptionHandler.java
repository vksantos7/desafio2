package com.example.desafio2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CarrosException.class)
    public ResponseEntity<ErrorCarrosResponse> carrosNotFound(CarrosException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorCarrosResponse(ex.getMessage()));
    }

    @ExceptionHandler(MotosException.class)
    public ResponseEntity<ErrorMotosResponse> motosNotFound(MotosException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMotosResponse(ex.getMessage()));
    }
}
