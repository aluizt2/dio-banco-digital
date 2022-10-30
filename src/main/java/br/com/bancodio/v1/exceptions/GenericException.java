package br.com.bancodio.v1.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericException extends RuntimeException {
    private String msg;
    private HttpStatus httpStatus;

    public GenericException(String message, HttpStatus httpStatus) {
        super(message);
        this.msg = message;
        this.httpStatus = httpStatus;
    }
}
