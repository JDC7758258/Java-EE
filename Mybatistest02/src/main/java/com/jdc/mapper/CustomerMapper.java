package com.jdc.mapper;

import com.jdc.pojo.Customer;

import java.util.List;

public interface CustomerMapper {
    List<Customer> findCustomerByUsernameAndJobs(Customer customer);
}
