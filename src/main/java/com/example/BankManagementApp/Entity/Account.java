package com.example.BankManagementApp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table 
public class Account {
    
    //Thease are the attributes of the Account class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long account_number;
    @Column
    private String account_holder_name;
    @Column
    private double account_balance;


    //Getter and Setter methods
    public long getAccount_number() {
        return account_number;
    }
    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }
    public String getAccount_holder_name() {
        return account_holder_name;
    }
    public void setAccount_holder_name(String account_holder_name) {
        this.account_holder_name = account_holder_name;
    }
    public double getAccount_balance() {
        return account_balance;
    }
    public void setAccount_balance(double account_balance) {
        this.account_balance = account_balance;
    }

    //Constructor
    public Account() {
    }

    //Constructor with parameters
    public Account(long account_number, String account_holder_name, double account_balance) {
        this.account_number = account_number;
        this.account_holder_name = account_holder_name;
        this.account_balance = account_balance;
    }


    //toString method to print the object in a readable format
    @Override
    public String toString() {
        return "Account [account_number=" + account_number + ", account_holder_name=" + account_holder_name
                + ", account_balance=" + account_balance + "]";
    }

    



}