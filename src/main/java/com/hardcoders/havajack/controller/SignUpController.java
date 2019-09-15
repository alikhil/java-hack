package com.hardcoders.havajack.controller;

import com.hardcoders.havajack.dto.SignUpDto;
import com.hardcoders.havajack.exception.AccountAlreadyExistException;
import com.hardcoders.havajack.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sign-up")
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;

    @PostMapping("/")
    public String signUp(@Valid SignUpDto signUpDto) throws AccountAlreadyExistException {
        return signUpService.signUp(signUpDto);
    }
}
