package com.UserApi.Api.Exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserException extends RuntimeException{

    private HttpStatus statusCode;

    public UserException(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
