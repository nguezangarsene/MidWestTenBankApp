package com.midwesten.bank.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ACCOUNTS")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    @NotNull(message = "* Account number is required")
    private Long accountNumber;

    @NotNull(message = "* balance is required")
    private double balance;

    @ManyToOne()
    @JoinColumn(name = "customerId", nullable = false)
    @NotNull(message = "* Customer is required")
    private Customer customer;



    @ManyToOne()
    @JoinColumn(name = "accountTypeId", nullable = false)
    @NotNull(message = "* Account type is required")
    private AccountType accountType;

    public Account(){}

    public Account(Long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
