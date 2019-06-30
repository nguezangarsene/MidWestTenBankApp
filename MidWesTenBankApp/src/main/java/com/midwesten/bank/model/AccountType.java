package com.midwesten.bank.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ACCOUNTTYPES")
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountTypeId;

    @NotNull(message = "* Account type is required")
    private String accountTypeName;

    @OneToMany(mappedBy = "accountType", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

    public AccountType(){
    }

    public AccountType( String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public int getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(int accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }
}
