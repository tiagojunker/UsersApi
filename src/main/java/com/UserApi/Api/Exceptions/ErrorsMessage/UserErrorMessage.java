package com.UserApi.Api.Exceptions.ErrorsMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class UserErrorMessage {

    private HttpStatus status;
    private String message;

}
