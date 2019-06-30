package com.midwesten.bank.repository;


import com.midwesten.bank.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountTypeRepository extends JpaRepository<AccountType, Integer> {
}
