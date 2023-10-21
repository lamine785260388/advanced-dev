package com.uadb.advancedev.resources.errors;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(Exception.class)
    private ResponseEntity<String> defaultException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<String> entityNotFound(EntityNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    private ResponseEntity<com.uadb.advancedev.resources.errors.ExceptionResponse> constraintViolation(ConstraintViolationException ex) {
        com.uadb.advancedev.resources.errors.ExceptionResponse body = new com.uadb.advancedev.resources.errors.ExceptionResponse();
        body.setStatus(HttpStatus.BAD_REQUEST);
        Map<String, String> message = new HashMap<>();

        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        List<ConstraintViolation<?>> list = constraintViolations.stream().toList();

        list.forEach(item -> message.put(item.getPropertyPath().toString(), item.getMessage()));

        body.setMessage(message);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }


}
