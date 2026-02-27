package com.felipe.api_dragon_city_h2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandle {

  // Entendi o Handle do Valid, mas custei a reproduzir, me apoiei no código das aulas.

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException exception) {
    Map<String, String> errors = new HashMap<>();
    exception.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage())
    );
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
  }

  // Esse eu procurei na internet, precisava para a entrada UUID.

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException exception) {
    return ResponseEntity.badRequest().body("ID inválido!");
  }

  // Criei essa Exception.

  @ExceptionHandler(EmptyRepositoryException.class)
  private ResponseEntity<String> emptyRepositoryException(EmptyRepositoryException exception) {
    return ResponseEntity.ok().body(exception.getMessage());
  }

  // Criei essa Exception.

  @ExceptionHandler(NotFoundIdException.class)
  private ResponseEntity<String> notFoundIdException(NotFoundIdException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }
}
