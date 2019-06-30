package com.midwesten.bank.service.impl;

import com.midwesten.bank.model.AccountType;
import com.midwesten.bank.repository.IAccountTypeRepository;
import com.midwesten.bank.service.IAccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeService implements IAccountTypeService {


    @Autowired
    private IAccountTypeRepository accountTypeRepository;

    @Override
    public List<AccountType> getAllAccountTypes() {
        return accountTypeRepository.findAll(Sort.by("accountTypeName"));
    }
}
