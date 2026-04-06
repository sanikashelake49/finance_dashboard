package com.finance.dashboard.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handle(Exception e) {
        return new ResponseEntity<>(
            new ApiError(e.getMessage(), 400),
            HttpStatus.BAD_REQUEST
        );
    }
}