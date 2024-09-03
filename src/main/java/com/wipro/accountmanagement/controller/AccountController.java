package com.wipro.accountmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.accountmanagement.model.Account;
import com.wipro.accountmanagement.model.Customer;
import com.wipro.accountmanagement.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account addAccount(@RequestBody Account account) {
        return accountService.addAccount(account);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return accountService.getAllCustomers();
    }

    @PostMapping("/transfer")
    public String transferFunds(@RequestParam String fromAccountNumber,
                                @RequestParam String toAccountNumber,
                                @RequestParam double amount) {
        return accountService.transferFunds(fromAccountNumber, toAccountNumber, amount);
    }

    @GetMapping("/balance")
    public double getBalanceOf(@RequestParam String accountNumber) {
        return accountService.getBalanceOf(accountNumber);
    }
}
