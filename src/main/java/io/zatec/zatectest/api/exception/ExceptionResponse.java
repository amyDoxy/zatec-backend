package io.zatec.zatectest.api.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Custom class for error message
 *
 * @author ganesh
 */
@Data public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private HttpStatus httpStatus;
    private String errorMessage;

    private final LocalDateTime timeStamp = LocalDateTime.now();

    public ExceptionResponse(HttpStatus httpStatus, String errorKey) {
        this.httpStatus = httpStatus;
        errorMessage = errorKey; // add translations
    }

    public ExceptionResponse(HttpStatus httpStatus, String errorKey, Object[] params) {
        this.httpStatus = httpStatus;
        errorMessage = errorKey; // add translations
    }

    public ExceptionResponse() {

    }
}
