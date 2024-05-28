package com.hrms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.security.access.AccessDeniedException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import com.hrms.response.ServiceStatus;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = { RuntimeException.class })
    public ResponseEntity<ServiceStatus> handleRuntimeException(RuntimeException ex) {
        
        ServiceStatus status = new ServiceStatus(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { DataIntegrityViolationException.class })
    public ResponseEntity<ServiceStatus> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
       
        String constraintMessage = extractConstraintViolationMessage(ex);

        
        String errorMessage = "Data integrity violation";
        if (constraintMessage != null) {
            errorMessage += ": " + constraintMessage;
        }

        
        ServiceStatus status = new ServiceStatus(HttpStatus.BAD_REQUEST.value(), errorMessage);

        
        return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
    }

 
    private String extractConstraintViolationMessage(DataIntegrityViolationException ex) {
        Throwable cause = ex.getCause();
        if (cause instanceof ConstraintViolationException) {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) cause;
            return constraintViolationException.getMessage();
        }
        return null;
    }


    @ExceptionHandler(value = { AccessDeniedException.class })
    public ResponseEntity<ServiceStatus> handleAccessDeniedException(AccessDeniedException ex) {
        
        ServiceStatus status = new ServiceStatus(HttpStatus.FORBIDDEN.value(), "Access denied: " + ex.getMessage());
        return new ResponseEntity<>(status, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<ServiceStatus> handleGenericException(Exception ex) {
        
        ServiceStatus status = new ServiceStatus(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal server error: " + ex.getMessage());
        return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
