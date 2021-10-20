package com.igreendata.account.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * IncorrectParameterException throws for incorrect parameters.
 * @author Dulip Chandana
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Setter
@Getter
public class IncorrectParameterException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public IncorrectParameterException( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s Sorting column is not correct . %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
