package com.tallerjavamysql.customer.application;

import com.tallerjavamysql.customer.domain.entity.Customer;
import com.tallerjavamysql.customer.domain.service.CustomerService;

public class CreateCustomerUseCase {
    private final CustomerService customerService;

    public CreateCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void execute(Customer customer) {
        customerService.createCustomer(customer);
    }
}
