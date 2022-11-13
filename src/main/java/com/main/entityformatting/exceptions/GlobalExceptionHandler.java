package com.main.entityformatting.exceptions;

import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.main.entityformatting.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse> DataIntegrityViolationExceptionHandler(DataIntegrityViolationException ex) {
        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        CustomException err = new CustomException(LocalDateTime.now(), HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<Object>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
        CustomException err = new CustomException(LocalDateTime.now(), HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<Object>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleUsernameNotFoundException(BadCredentialsException ex) {
        CustomException err = new CustomException(LocalDateTime.now(), HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<Object>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidJwtAuthenticationException.class)
    public ResponseEntity<Object> handleInvalidJwtAuthenticationException(InvalidJwtAuthenticationException ex) {
        CustomException err = new CustomException(LocalDateTime.now(), HttpStatus.UNAUTHORIZED, ex.getMessage());
        return new ResponseEntity<Object>(err, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Object> handleUsernameNotFoundException(UsernameNotFoundException ex) {
        CustomException err = new CustomException(LocalDateTime.now(), HttpStatus.UNAUTHORIZED,
                "Expired or invalid JWT token");
        return new ResponseEntity<Object>(err, HttpStatus.UNAUTHORIZED);
    }
}
