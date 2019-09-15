package com.hardcoders.havajack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountAlreadyExistException extends HavaJackException {

    public AccountAlreadyExistException(String message) {
        super(message);
    }
}
