package com.tallerjavamysql.customer.domain.service;

import java.util.List;

import com.tallerjavamysql.customer.domain.entity.Customer;

public interface CustomerService {
    public void createCustomer(Customer customer);

    public void updateCustomer(Customer customer, String idcustomer);

    public void deleteCustomer(String idcustomer);

    public List<Customer> findAllCustomers();

    public Customer findByIdCustomer(String idcustomer);
}
