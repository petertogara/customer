package com.petmuc.customer.service;

import com.petmuc.customer.domain.Customer;
import com.petmuc.customer.domain.EmailAddress;
import com.petmuc.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void changeEmail(final long customerId,final EmailAddress emailAddress) {

        Customer customer = this.customerRepository.findById(customerId).orElseThrow(() ->
                new IllegalArgumentException(String.format("Could not find customer with id: %s  ", customerId)));
        customer.changeEmail(emailAddress);
        this.customerRepository.save(customer);

    }

}
