package com.petmuc.customer.service;

import com.petmuc.customer.mapper.CustomerMapper;
import com.petmuc.customer.domain.Customer;
import com.petmuc.customer.domain.EmailAddress;
import com.petmuc.customer.messaging.event.CustomerEvent;
import com.petmuc.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository customerRepository;

    final Sinks.Many<CustomerEvent> customerProducer;

    @Override
    public Customer create(Customer customer) {
        Customer createdCustomer = customerRepository.save(customer);
        var customerCreatedEvent  =  new CustomerEvent.CustomerCreatedEvent(customer.getId(), Instant.now(), CustomerMapper.mapToDto(customer));
        customerProducer.tryEmitNext(customerCreatedEvent);
        return createdCustomer;
    }

    @Override
    public void changeEmail(final long customerId, final EmailAddress emailAddress) {

        Customer customer = this.customerRepository.findById(customerId).orElseThrow(() ->
                new IllegalArgumentException(String.format("Could not find customer with id: %s  ", customerId)));
        customer.changeEmail(emailAddress);
        this.customerRepository.save(customer);

    }

}
