package com.midwesten.bank.service;


import com.midwesten.bank.model.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountService {

    List<Account> getAllAccounts();
    Account addNewAccount(Account account);
    Double computeNetLiquidity();
    Optional<Account> findByAccountNumber(Long accountNumber);

}
