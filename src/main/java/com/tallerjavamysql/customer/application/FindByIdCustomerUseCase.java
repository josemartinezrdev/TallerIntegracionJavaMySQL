package com.tallerjavamysql.customer.application;

import com.tallerjavamysql.customer.domain.entity.Customer;
import com.tallerjavamysql.customer.domain.service.CustomerService;

public class FindByIdCustomerUseCase {
    private final CustomerService customerService;

    public FindByIdCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer execute(String idcustomer) {
        return customerService.findByIdCustomer(idcustomer);
    }
}
