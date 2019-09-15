package com.hardcoders.havajack.service;

import com.hardcoders.havajack.dto.SignUpDto;
import com.hardcoders.havajack.dto.VerificationCodeSumDto;
import com.hardcoders.havajack.exception.AccountAlreadyExistException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Repository;
import org.springframework.web.HttpRequestMethodNotSupportedException;

@Repository
public interface SignUpService {

    String signUp(SignUpDto signUpDto) throws AccountAlreadyExistException;
}
