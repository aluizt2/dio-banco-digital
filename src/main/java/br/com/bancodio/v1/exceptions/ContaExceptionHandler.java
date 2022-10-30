package br.com.bancodio.v1.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ContaExceptionHandler {

    @ExceptionHandler(value = {GenericException.class})
    public ResponseEntity<CustomErrorResponse> genericException(GenericException e) {
        return new ResponseEntity<>(
                CustomErrorResponse.builder()
                        .errorMsg(e.getMsg())
                        .httpStatus(e.getHttpStatus().value())
                        .build(), e.getHttpStatus());
    }
}
