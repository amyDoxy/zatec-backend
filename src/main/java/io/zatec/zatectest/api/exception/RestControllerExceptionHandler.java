package io.zatec.zatectest.api.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * Global exception handler for all exceptions to be thrown by rest controller
 *
 * @author amy.muhimpundu
 */
@Slf4j @ControllerAdvice public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String BAD_INPUT_PARAMETER = "bad.input.parameter";
    private static final String SEMICOLON = ":";

    /**
     * Custom error message when there is constraint violation exception
     */
    @ExceptionHandler(ConstraintViolationException.class) ResponseEntity<Object> handleConstraintViolationException(
            ConstraintViolationException exception) {
        log.error(exception.getMessage(), exception);
        String message = exception.getConstraintViolations().stream().findFirst().map(ConstraintViolation::getMessageTemplate)
                .orElse(BAD_INPUT_PARAMETER);
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST, message);
        return new ResponseEntity<>(exceptionResponse, new HttpHeaders(), exceptionResponse.getHttpStatus());
    }

    /**
     * Custom error message when there is bind exception
     */
    @Override public ResponseEntity<Object> handleBindException(BindException exception, HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        log.error(exception.getMessage(), exception);
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST,
                exception.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return new ResponseEntity<>(exceptionResponse, new HttpHeaders(), exceptionResponse.getHttpStatus());
    }

    /**
     * Return custom error message if argument data is invalid
     *
     * @param exception {@link MethodArgumentNotValidException}
     * @return {@link ExceptionResponse}
     */
    @Override public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        log.error(exception.getMessage(), exception);
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST,
                exception.getBindingResult().getAllErrors().get(0).getDefaultMessage());

        return new ResponseEntity<>(exceptionResponse, new HttpHeaders(), exceptionResponse.getHttpStatus());
    }

    /**
     * Custom Error Message for {@link HttpMessageNotReadableException}
     *
     * @param exception {@link HttpMessageNotReadableException}
     * @return {@link ResponseEntity<Object>}
     */
    @Override public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        log.error(exception.getMessage(), exception);
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST, BAD_INPUT_PARAMETER);
        return new ResponseEntity<>(exceptionResponse, new HttpHeaders(), exceptionResponse.getHttpStatus());
    }

}
