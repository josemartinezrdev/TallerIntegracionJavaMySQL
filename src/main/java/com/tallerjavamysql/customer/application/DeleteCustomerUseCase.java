package com.tallerjavamysql.customer.application;

import com.tallerjavamysql.customer.domain.service.CustomerService;

public class DeleteCustomerUseCase {
    private final CustomerService customerService;

    public DeleteCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void execute(String idcustomer) {
        customerService.deleteCustomer(idcustomer);
    }
}
