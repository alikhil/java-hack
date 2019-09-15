package com.hardcoders.havajack.controller;

import com.hardcoders.havajack.dto.CredentialsDto;
import com.hardcoders.havajack.dto.TokenDto;
import com.hardcoders.havajack.exception.AccountAlreadyExistException;
import com.hardcoders.havajack.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/sign-up")
    public TokenDto signUp(@RequestBody @Valid CredentialsDto credentialsDto) throws AccountAlreadyExistException {
        return accountService.signUp(credentialsDto);
    }

    @GetMapping("/sign-in")
    public TokenDto signIn(@RequestBody @Valid CredentialsDto credentialsDto) {
        return accountService.signIn(credentialsDto);
    }
}
