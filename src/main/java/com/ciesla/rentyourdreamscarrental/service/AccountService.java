package com.ciesla.rentyourdreamscarrental.service;

import com.ciesla.rentyourdreamscarrental.entity.Account;
import com.ciesla.rentyourdreamscarrental.repository.AccountRepository;
import com.ciesla.rentyourdreamscarrental.repository.RentalRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final RentalRequestRepository rentalRequestRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, RentalRequestRepository rentalRequestRepository) {
        this.accountRepository = accountRepository;
        this.rentalRequestRepository = rentalRequestRepository;
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

    @Transactional
    public void deleteRequestsByAccountId(Integer id) {
        rentalRequestRepository.deleteRentalRequestsByAccountId(id);
    }
}
