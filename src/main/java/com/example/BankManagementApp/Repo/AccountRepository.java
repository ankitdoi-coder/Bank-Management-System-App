package com.example.BankManagementApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BankManagementApp.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    

}
