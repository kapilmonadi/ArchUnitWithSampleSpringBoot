package com.kta.sample.advice;

import com.kta.sample.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleInvalidUser(UserNotFoundException userNotFoundException){
        String message = userNotFoundException.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}