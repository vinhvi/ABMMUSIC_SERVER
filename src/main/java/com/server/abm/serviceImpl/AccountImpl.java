package com.server.abm.serviceImpl;

import com.server.abm.config.JwtService;
import com.server.abm.entity.Account;
import com.server.abm.repository.AccountRepository;
import com.server.abm.service.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AccountImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;
    @Override
    public Optional<Account> getByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public Account getById(Integer id) {
        return accountRepository.findAccountById(id);
    }

    @Override
    public Account register(Account account) {
        String password = account.getPassWordAccount();
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        String encodedPassword = passwordEncoder.encode(password);
        account.setPassWordAccount(encodedPassword);
        return accountRepository.save(account);
    }

    @Override
    public String login(Account account) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
        var user = accountRepository.findByEmail(account.getEmail()).orElseThrow();
        return jwtService.generateToken(user);
    }
}
