package com.petmuc.customer.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private FirstName firstName;
    private LastName lastName;
    private BirthDate birthDate;
    private EmailAddress emailAddress;
    private Phone phone;
    private Ssn ssn;

    private Customer(FirstName firstName, LastName lastName, BirthDate birthDate, EmailAddress emailAddress, Phone phone, Ssn ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.emailAddress = emailAddress;
        this.phone = phone;
        this.ssn =  ssn;
    }

    public static Customer create(FirstName firstName, LastName lastName, BirthDate birthDate, EmailAddress emailAddress, Phone phone, Ssn ssn) {
        return new Customer(firstName, lastName, birthDate, emailAddress, phone, ssn);
    }

    public void changeEmail(final EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }
}
