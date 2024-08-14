package com.tallerjavamysql.customer.application;

import com.tallerjavamysql.customer.domain.entity.Customer;
import com.tallerjavamysql.customer.domain.service.CustomerService;

public class UpdateCustomerUseCase {
    private final CustomerService customerService;

    public UpdateCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void execute(Customer customer, String idcustomer) {
        customerService.updateCustomer(customer, idcustomer);
    }
}
