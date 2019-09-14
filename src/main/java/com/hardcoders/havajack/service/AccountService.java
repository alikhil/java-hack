package com.hardcoders.havajack.service;

import com.hardcoders.havajack.model.Account;
import com.hardcoders.havajack.repository.UserRepository;
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
public class AccountService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public AccountService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        Account account = userRepository.findByPhone(phone);

        if(account == null) {
            throw new UsernameNotFoundException(String.format("The user with phone number %s doesn't exist", phone));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        account.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));

        return new org.springframework.security.core.userdetails.User(account.getPhone(), account.getPassword(), authorities);
    }
}
