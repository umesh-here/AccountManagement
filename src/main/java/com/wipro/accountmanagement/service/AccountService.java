package com.wipro.accountmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.accountmanagement.model.Account;
import com.wipro.accountmanagement.model.Customer;
import com.wipro.accountmanagement.repository.AccountRepository;
import com.wipro.accountmanagement.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public String transferFunds(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber);
        Account toAccount = accountRepository.findByAccountNumber(toAccountNumber);

        if (fromAccount == null || toAccount == null) {
            return "ID MISMATCH";
        }

        if (fromAccount.getBalance() < amount) {
            return "INSUFFICIENT FUNDS";
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        return "SUCCESS";
    }

    public double getBalanceOf(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        return account != null ? account.getBalance() : -1; // -1 indicates account not found
    }
}