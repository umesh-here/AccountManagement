package com.wipro.accountmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.accountmanagement.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	 Account findByAccountNumber(String accountNumber);

}
