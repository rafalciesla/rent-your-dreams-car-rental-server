package com.ciesla.rentyourdreamscarrental.service;

import com.ciesla.rentyourdreamscarrental.entity.Account;
import com.ciesla.rentyourdreamscarrental.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> showAllAccounts() {
        return accountRepository.findAll();
    }

    public Account showAccountById(Integer id) {
        return accountRepository.findAccountById(id);
    }

    public void save(Account account) {
        accountRepository.save(account);
    }

    public Account showAccountByEmail(String email) {
        Account account = accountRepository.findAccountByEmail(email);
        return account;
    }

    public void updateAccount(Account account) {
        accountRepository.save(account);
    }
}
