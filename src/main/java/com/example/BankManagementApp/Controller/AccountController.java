package com.example.BankManagementApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankManagementApp.Entity.Account;
import com.example.BankManagementApp.Service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService service;
    //create account
    @PostMapping("/create")
    public ResponseEntity createAccount(@RequestBody Account account) {
        Account createAccount=service.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
    }

    //get account details by account number
@GetMapping("/{accountNumber}")
public Account getAccountByAccountNumber(@PathVariable Long accountNumber){
    Account account=service.getAccountDetailByAccountNumber(accountNumber);

    return account;

    
}

//Get all account details
@GetMapping("/getallaccounts")
public List<Account> getAllAccountDetails(){
    List<Account> allAccountdetails=service.getAllAccountDetails();
    return allAccountdetails;
}

//Deposit amount
@PutMapping("/deposit/{accountNumber}/{amount}")
public Account deposiAccount(@PathVariable Long accountNumber,@PathVariable double amount){
    Account account=service.depositAmount(accountNumber, amount);
    return  account;
}

//withdraw amount
@PutMapping("/withdraw/{accountNumber}/{amount}")
public Account withdrawAccount(@PathVariable Long accountNumber,@PathVariable double amount){
    Account account=service.withdrawAmount(accountNumber, amount);
    return  account;
}

//close Account
@DeleteMapping("/delete/{accountNumber}")
public ResponseEntity deleteAccount(@PathVariable Long accountNumber )
{
    service.closeAccount(accountNumber);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Account_closed");
}
}
