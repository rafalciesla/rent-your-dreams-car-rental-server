package com.ciesla.rentyourdreamscarrental.controller;

import com.ciesla.rentyourdreamscarrental.entity.Account;
import com.ciesla.rentyourdreamscarrental.entity.RentalRequest;
import com.ciesla.rentyourdreamscarrental.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/show/all")
    public List<Account> showAllAccounts() {
        return accountService.showAllAccounts();
    }

    @GetMapping("/show/{id}")
    public Account showAccountById(@PathVariable("id") Integer id) {
        return accountService.showAccountById(id);
    }

    @GetMapping("/show/email")
    public Account showAccountByEmail(@RequestParam("email") String email) {
        Account account = accountService.showAccountByEmail(email);
        return account;
    }

    @CrossOrigin(origins = "http://localhost:8383")
    @PostMapping("/mailcheck")
    public ResponseEntity<String> mailCheck(@RequestBody String email) {
        Account account = accountService.showAccountByEmail(email);
        if(account == null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FOUND);
        }
    }

    @CrossOrigin(origins = "http://localhost:8383")
    @PostMapping("/register")
    public ResponseEntity<String> registerAccount(@RequestBody Account account) {
        accountService.save(account);
        return new ResponseEntity<>("New account added", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAccount(@RequestBody Account account) {
        accountService.updateAccount(account);
        return new ResponseEntity<>("Account has been updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete/requests/{id}")
    public ResponseEntity<String> deleteRequestsByAccountId(@PathVariable("id") Integer id) {
        accountService.deleteRequestsByAccountId(id);
        return new ResponseEntity<>("Requests from account with id=" + id + " has been deleted", HttpStatus.OK);
    }
}
