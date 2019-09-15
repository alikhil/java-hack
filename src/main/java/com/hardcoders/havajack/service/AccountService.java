package com.hardcoders.havajack.service;

import com.hardcoders.havajack.dto.CredentialsDto;
import com.hardcoders.havajack.dto.TokenDto;
import com.hardcoders.havajack.exception.AccountAlreadyExistException;
import com.hardcoders.havajack.model.Account;
import com.hardcoders.havajack.repository.AccountRepository;
import com.hardcoders.havajack.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier(value = "accountService")
public class AccountService implements UserDetailsService, SignUpService {

    private AccountRepository accountRepository;
    private ClientService clientService;

    @Autowired
    public AccountService(AccountRepository accountRepository, ClientService clientService) {
        this.accountRepository = accountRepository;
        this.clientService = clientService;
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
        String phone = credentialsDto.getPhone();
        String password = credentialsDto.getPassword();
        phone = CommonUtils.normalizePhone(phone);
        Account account = accountRepository.findByPhone(phone);
        if (account != null) {
            //TODO: encode password
            if (account.getPassword().equals(password)) {
                return new TokenDto(account.getToken());
            }
        }
        throw new UsernameNotFoundException(String.format("The user with phone number %s doesn't exist", phone));
    }

    @Override
    @Transactional
    public TokenDto signUp(CredentialsDto credentialsDto) throws AccountAlreadyExistException {
        String phone = credentialsDto.getPhone();
        String password = credentialsDto.getPassword();
        phone = CommonUtils.normalizePhone(phone);
        Account account = accountRepository.findByPhone(phone);
        if (account == null) {
            account = Account.builder()
                    .phone(phone).password(password)
                    .verificationCode(CommonUtils.generateVerificationCode())
                    .token(CommonUtils.generateUUID())
                    .build();
            accountRepository.save(account);
            clientService.createClient(account);
            return new TokenDto(account.getToken());
        }
        throw new AccountAlreadyExistException(String.format("Account with phone number %s already exist",
                phone));
    }
}
