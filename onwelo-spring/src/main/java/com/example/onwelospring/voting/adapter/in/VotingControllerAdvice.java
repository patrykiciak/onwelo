package com.example.onwelospring.voting.adapter.in;

import com.example.onwelospring.voting.exception.InvalidReferenceException;
import com.example.onwelospring.voting.exception.InvalidRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class VotingControllerAdvice {

    @ExceptionHandler(InvalidReferenceException.class)
    ResponseEntity<String> handleException(InvalidReferenceException e) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body("Invalid object reference");
    }

    @ExceptionHandler(InvalidRequestException.class)
    ResponseEntity<String> handleException(InvalidRequestException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Invalid request");
    }
}
