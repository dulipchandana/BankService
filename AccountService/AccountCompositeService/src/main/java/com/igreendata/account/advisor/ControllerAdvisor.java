package com.igreendata.account.advisor;

import com.igreendata.account.exception.IncorrectParameterException;
import com.igreendata.account.exception.ResourceNotFoundException;
import com.igreendata.account.util.AccountConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ControllerAdvisor for handle api level exceptions.
 * @author Dulip Chandana
 *
 */
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(
            ResourceNotFoundException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put(AccountConstant.TIME_STAMP, LocalDateTime.now());
        body.put(AccountConstant.MESSAGE,ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncorrectParameterException.class)
    public ResponseEntity<Object> handleIncorrectParameterException(
            IncorrectParameterException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put(AccountConstant.TIME_STAMP, LocalDateTime.now());
        body.put(AccountConstant.MESSAGE,ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
