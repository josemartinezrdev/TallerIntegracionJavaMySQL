package com.tallerjavamysql.customer.application;

import java.util.List;

import com.tallerjavamysql.customer.domain.entity.Customer;
import com.tallerjavamysql.customer.domain.service.CustomerService;

public class FindAllCustomerUseCase {
    private final CustomerService customerService;

    public FindAllCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> execute() {
        return customerService.findAllCustomers();
    }
}
