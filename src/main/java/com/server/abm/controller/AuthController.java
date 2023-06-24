package com.server.abm.controller;

import com.server.abm.entity.Account;
import com.server.abm.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthController {

    private final AccountService accountService;

    @PostMapping("/account/register")
    public ResponseEntity<?> registerAccount(@RequestBody Account account) {
        if (accountService.getByEmail(account.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("email đã đc đăng kí");
        } else {
            Account registeredAccount = accountService.register(account);
            if (registeredAccount == null) {
                return ResponseEntity.badRequest().body("Error !!");
            }
            return ResponseEntity.ok().body("đăng kí thành công");
        }
    }

    @PostMapping("/account/login")
    public ResponseEntity<?> login(@RequestBody Account account) {
        String token = accountService.login(account);
        if (token != null) {
            return ResponseEntity.ok().body(token);
        } else {
            return ResponseEntity.badRequest().body("Tài khoản hoặc mật khẩu khôn đúng !!");
        }

    }

}
