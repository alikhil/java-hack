package com.hardcoders.havajack.service.implementation;

import com.hardcoders.havajack.dto.SignUpDto;
import com.hardcoders.havajack.exception.AccountAlreadyExistException;
import com.hardcoders.havajack.model.Account;
import com.hardcoders.havajack.repository.AccountRepository;
import com.hardcoders.havajack.service.SignUpService;
import com.hardcoders.havajack.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final AccountRepository accountRepository;

    @Override
    public String signUp(SignUpDto signUpDto) throws AccountAlreadyExistException {
        var phone = signUpDto.getPhone();
        var password = signUpDto.getPassword();
        phone = CommonUtils.normalizePhone(phone);
        var account = accountRepository.findByPhone(phone);
        if (account == null) {
            account = Account.builder()
                    .phone(phone).password(password)
                    .verificationCode(CommonUtils.generateVerificationCode())
                    .token(CommonUtils.generateUUID())
                    .build();
            accountRepository.save(account);
            return account.getToken();
        }
        throw new AccountAlreadyExistException(String.format("Account with phone number %s already exist",
                phone));
    }
}
