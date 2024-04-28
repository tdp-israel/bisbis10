package com.att.tdp.bisbis10.controlleradvice;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.att.tdp.bisbis10.exception.InvalidValueException;
import com.att.tdp.bisbis10.exception.ItemNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleInvalidArgument(MethodArgumentNotValidException e) {
        List<String> errorMessages = e.getBindingResult().getFieldErrors().stream()
            .map(FieldError::getDefaultMessage)
            .collect(Collectors.toList());

        ErrorResponse error = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            errorMessages
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Handles Json Parsing Errors - when data is received with the wrong type
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleInvalidDatatypeArgument(HttpMessageNotReadableException e) {
        List<String> errorMessages = List.of(
            e.getMessage()
        );

        ErrorResponse error = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            errorMessages
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidValueException.class)
    public ResponseEntity<ErrorResponse> handleInvalidValue(InvalidValueException e) {
        List<String> errorMessages = List.of(
            e.getMessage()
        );

        ErrorResponse error = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            errorMessages
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleInvalidValue(ItemNotFoundException e) {
        List<String> errorMessages = List.of(
            e.getMessage()
        );

        ErrorResponse error = new ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            errorMessages
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
