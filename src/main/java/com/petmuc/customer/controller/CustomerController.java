package com.petmuc.customer.controller;

import com.petmuc.customer.controller.dto.CustomerDto;
import com.petmuc.customer.domain.*;
import com.petmuc.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody @Valid final CustomerDto dto) {

        FirstName firstName = FirstName.of(dto.getFirstName());
        LastName lastName = LastName.of(dto.getLastName());
        BirthDate birthDate = BirthDate.of(dto.getBirthDate());
        EmailAddress email = EmailAddress.of(dto.getEmailAddress());
        Phone phone = Phone.of(dto.getPhone());

        Customer customer = Customer.create(firstName, lastName, birthDate, email, phone);

        Customer createdCustomer = customerService.create(customer);
        return ResponseEntity.ok(createdCustomer);
    }
}
