package com.example.desafio2.exception;

<<<<<<< HEAD
=======

>>>>>>> 048a7a689c16e5a02ba4abfe4296046377bf05f6
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

<<<<<<< HEAD
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
=======

    @ExceptionHandler(FuncionarioException.class)
    public ResponseEntity<String> clienteNotFound(FuncionarioException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(FornecedorException.class)
    public ResponseEntity<String> clienteNotFound(FornecedorException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    }
>>>>>>> 048a7a689c16e5a02ba4abfe4296046377bf05f6
