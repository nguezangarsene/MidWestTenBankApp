package com.midwesten.bank.service;

import com.midwesten.bank.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    List<Customer> getAllCustomers();
    Customer addNewCustomer(Customer customer);
    Optional<Customer> findByCustomerNumber(Long customerNumber);

}
