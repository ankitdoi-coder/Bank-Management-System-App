package com.example.BankManagementApp.Service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankManagementApp.Entity.Account;
import com.example.BankManagementApp.Repo.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountRepository repo;

    @Override
    public Account createAccount(Account account) {
        Account account_saved=   repo.save(account);
        return account_saved;
    }

    @Override
    public Account getAccountDetailByAccountNumber(long accountNumber) {
        Optional<Account> account=repo.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account Not Exist");
        }
        Account account_found=account.get();
        return account_found;
    }

    @Override
    public List<Account> getAllAccountDetails() {
    return repo.findAll();
}


    @Override
    public Account depositAmount(long accountNumber, double amount) {
       Optional <Account> account =repo.findById(accountNumber);
       if(account.isEmpty()){
        throw new RuntimeException("Account Not Exist");
       }
         Account account_present=account.get();
         Double totalBalance=account_present.getAccount_balance()+amount;
         account_present.setAccount_balance(totalBalance);
         repo.save(account_present);
         return account_present;

    }

    @Override
    public Account withdrawAmount(long accountNumber, double amount) {
        Optional <Account> account =repo.findById(accountNumber);
        if(account.isEmpty()){
         throw new RuntimeException("Account Not Exist");
        }
        Account account_present=account.get();

        double account_Balance=account_present.getAccount_balance()-amount;
        account_present.setAccount_balance(account_Balance);
        repo.save(account_present);
        return account_present;
    }

    @Override
    public void closeAccount(long accountNumber) {
        getAccountDetailByAccountNumber(accountNumber);
        repo.deleteById(accountNumber);

    }

}
