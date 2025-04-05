package com.example.BankManagementApp.Service;

import java.util.List;

import com.example.BankManagementApp.Entity.Account;

public interface AccountService {
    public Account createAccount(Account account);
    public Account getAccountDetailByAccountNumber(long accountNumber);
    public List<Account>  getAllAccountDetails();
    public Account depositAmount(long accountNumber, double amount);
    public Account withdrawAmount(long accountNumber, double amount);
    public void closeAccount(long accountNumber);
}
