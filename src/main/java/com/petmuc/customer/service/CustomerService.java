package com.petmuc.customer.service;

import com.petmuc.customer.domain.Customer;
import com.petmuc.customer.domain.EmailAddress;

public interface CustomerService {
    Customer create(Customer customer);

    void changeEmail(long customerId, EmailAddress emailAddress);
}
