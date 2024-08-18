package com.UserApi.Api.Exceptions.ControllerAdvice;

import com.UserApi.Api.Exceptions.ErrorsMessage.UserErrorMessage;
import com.UserApi.Api.Exceptions.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserException.class)
    private ResponseEntity<UserErrorMessage> attributeAlreadyUsed(UserException exception) {
        UserErrorMessage response = new UserErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return new ResponseEntity<>(response, exception.getStatusCode());
    }

}
