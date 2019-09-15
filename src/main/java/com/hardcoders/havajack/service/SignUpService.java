package com.hardcoders.havajack.service;

import com.hardcoders.havajack.dto.CredentialsDto;
import com.hardcoders.havajack.dto.TokenDto;
import com.hardcoders.havajack.exception.AccountAlreadyExistException;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpService {

    TokenDto signIn(CredentialsDto credentialsDto);

    TokenDto signUp(CredentialsDto credentialsDto) throws AccountAlreadyExistException;
}
