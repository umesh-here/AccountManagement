package com.wipro.accountmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.accountmanagement.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
