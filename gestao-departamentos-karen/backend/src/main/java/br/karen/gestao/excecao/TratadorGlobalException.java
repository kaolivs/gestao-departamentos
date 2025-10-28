package br.karen.gestao.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class TratadorGlobalException {
    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Map<String, String>> negocio(NegocioException e) {
        Map<String, String> b = new HashMap<>();
        b.put("erro", e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(b);
    }
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> naoEncontrado(RecursoNaoEncontradoException e) {
        Map<String, String> b = new HashMap<>();
        b.put("erro", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(b);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validacao(MethodArgumentNotValidException e) {
        Map<String, String> b = new HashMap<>();
        b.put("erro", e.getBindingResult().getFieldError().getDefaultMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(b);
    }
}
