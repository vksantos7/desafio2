import com.example.desafio2.entity.SeguroEntity;
import com.example.desafio2.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

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

    @ExceptionHandler(FuncionarioException.class)
    public ResponseEntity<String> clienteNotFound(FuncionarioException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(FornecedorException.class)
    public ResponseEntity<String> clienteNotFound(FornecedorException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
@ExceptionHandler(SegurosException.class)
public ResponseEntity<Map<String, Object>> handleSegurosException(SegurosException ex) {
    Map<String, Object> body = Map.of(
            "timestamp", LocalDateTime.now(),
            "status", HttpStatus.BAD_REQUEST.value(),
            "erro", "Erro no processamento do seguro",
            "mensagem", ex.getMessage()
    );
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);

    }

public void main() {
}

