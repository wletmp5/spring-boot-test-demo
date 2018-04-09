package com.controller;

import com.domain.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("accounts/")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable long accountId) {
        Optional<Account> account = accountService.findAccountById(accountId);
        return account.isPresent() ? ResponseEntity.ok(account.get()) : ResponseEntity.notFound().build();
    }
}
