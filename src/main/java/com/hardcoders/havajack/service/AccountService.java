package com.hardcoders.havajack.service;

import com.hardcoders.havajack.dto.CredentialsDto;
import com.hardcoders.havajack.dto.TokenDto;
import com.hardcoders.havajack.exception.AccountAlreadyExistException;
import com.hardcoders.havajack.model.Account;
import com.hardcoders.havajack.repository.AccountRepository;
import com.hardcoders.havajack.utils.CommonUtils;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier(value = "accountService")
public class AccountService implements UserDetailsService, SignUpService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        Account account = accountRepository.findByPhone(phone);
        if(account != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            account.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
            return new org.springframework.security.core.userdetails.User(account.getPhone(), account.getPassword(), authorities);
        }
        throw new UsernameNotFoundException(String.format("The user with phone number %s doesn't exist", phone));
    }


    @Override
    public TokenDto signIn(CredentialsDto credentialsDto) {
        var phone = credentialsDto.getPhone();
        var password = credentialsDto.getPassword();
        var account = accountRepository.findByPhone(phone);
        if (account != null) {
            //TODO: encode password
            if (account.getPassword().equals(password)) {
                return new TokenDto(account.getToken());
            }
        }
        throw new UsernameNotFoundException(String.format("The user with phone number %s doesn't exist", phone));
    }

    @Override
    public TokenDto signUp(CredentialsDto credentialsDto) throws AccountAlreadyExistException {
        var phone = credentialsDto.getPhone();
        var password = credentialsDto.getPassword();
        phone = CommonUtils.normalizePhone(phone);
        var account = accountRepository.findByPhone(phone);
        if (account == null) {
            account = Account.builder()
                    .phone(phone).password(password)
                    .verificationCode(CommonUtils.generateVerificationCode())
                    .token(CommonUtils.generateUUID())
                    .build();
            accountRepository.save(account);
            return new TokenDto(account.getToken());
        }
        throw new AccountAlreadyExistException(String.format("Account with phone number %s already exist",
                phone));
    }
}
