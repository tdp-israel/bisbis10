package com.att.tdp.bisbis10.controlleradvice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.att.tdp.bisbis10.exception.InvalidValueException;
import com.att.tdp.bisbis10.exception.ItemNotFoundException;
import com.att.tdp.bisbis10.exception.dish.DishDoesNotBelongToRestaurantException;

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

    // Handles Json Parsing Errors - when data is received with the wrong type in the RequestBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleInvalidDatatypeArgument(HttpMessageNotReadableException e) {
        
        ErrorResponse error = createErrorResponseWithSingleMessage(
            e, HttpStatus.BAD_REQUEST.value()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Handles Json Parsing Errors - when data is received with the wrong type in the url(query/param)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleInvalidDatatypeArgument(MethodArgumentTypeMismatchException e) {
        
        ErrorResponse error = createErrorResponseWithSingleMessage(
            e, HttpStatus.BAD_REQUEST.value()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidValueException.class)
    public ResponseEntity<ErrorResponse> handleInvalidValue(InvalidValueException e) {
        
        ErrorResponse error = createErrorResponseWithSingleMessage(
            e, HttpStatus.BAD_REQUEST.value()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleInvalidValue(ItemNotFoundException e) {
        
        ErrorResponse error = createErrorResponseWithSingleMessage(
            e, HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DishDoesNotBelongToRestaurantException.class)
    public ResponseEntity<ErrorResponse> handleInvalidValue(DishDoesNotBelongToRestaurantException e) {
        
        ErrorResponse error = createErrorResponseWithSingleMessage(
            e, HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    public ErrorResponse createErrorResponseWithSingleMessage(Exception e, Integer status) {
        List<String> errorMessages = List.of(
            e.getMessage()
        );

        ErrorResponse error = new ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            errorMessages
        );

        return error;
    }
}
