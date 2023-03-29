package com.petmuc.customer.service;

import com.petmuc.customer.domain.Customer;
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

}
