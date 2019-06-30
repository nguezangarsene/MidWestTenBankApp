package com.midwesten.bank.service.impl;

import com.midwesten.bank.model.Customer;
import com.midwesten.bank.repository.ICustomerRepository;
import com.midwesten.bank.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {


    @Autowired
    private ICustomerRepository customerRepository;


    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll(Sort.by("lastName"));
    }

    @Override
    public Customer addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findByCustomerNumber(Long customerNumber) {
        return customerRepository.findAll().stream()
                .filter(p -> p.getCustomerNumber().equals(customerNumber))
                .findFirst();
    }
}
