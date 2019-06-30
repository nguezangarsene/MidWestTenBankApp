package com.midwesten.bank.service.impl;

import com.midwesten.bank.model.Account;
import com.midwesten.bank.repository.IAccountRepository;
import com.midwesten.bank.service.IAccountService;
import com.midwesten.bank.service.IAccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    public AccountService(){

    }

    public AccountService(IAccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll(Sort.by("accountNumber"));
    }

    @Override
    public Account addNewAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Double computeNetLiquidity() {
        Double sum1  = accountRepository.findAll(Sort.by("accountNumber")).stream()
                .filter(x -> x.getAccountType().getAccountTypeId() == 1 || x.getAccountType().getAccountTypeId() == 3)
                .mapToDouble(x -> x.getBalance()).sum();
        Double sum2 = accountRepository.findAll().stream()
                .filter(x -> x.getAccountType().getAccountTypeId() == 2)
                .mapToDouble(x -> x.getBalance()).sum();


        return sum1 - sum2;
    }

    @Override
    public Optional<Account> findByAccountNumber(Long accountNumber) {
        return accountRepository.findAll().stream()
                .filter(p -> p.getAccountNumber().equals(accountNumber))
                .findFirst();
    }


}
