package com.petmuc.customer.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
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

    public Customer(FirstName firstName, LastName lastName, BirthDate birthDate, EmailAddress emailAddress, Phone phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.emailAddress = emailAddress;
        this.phone = phone;
    }
}
