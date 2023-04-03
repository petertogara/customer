package com.petmuc.customer.mapper;

import com.petmuc.customer.controller.dto.CustomerDto;
import com.petmuc.customer.domain.*;

public interface CustomerMapper {

    static Customer mapToCustomer(final CustomerDto dto){
        FirstName firstName = FirstName.of(dto.getFirstName());
        LastName lastName = LastName.of(dto.getLastName());
        BirthDate birthDate = BirthDate.of(dto.getBirthDate());
        EmailAddress email = EmailAddress.of(dto.getEmailAddress());
        Phone phone = Phone.of(dto.getPhone());
        Ssn ssn = Ssn.create(dto.getSsn());

        return Customer.create(firstName, lastName, birthDate, email, phone, ssn);
    }


    static CustomerDto mapToDto(final Customer customer) {
        return new CustomerDto(customer.getFirstName().getValue(),
                customer.getLastName().getValue(),
                customer.getBirthDate().getValue(),
                customer.getEmailAddress().getValue(),
                customer.getPhone().getValue(),
                customer.getSsn().getValue());
    }
}
