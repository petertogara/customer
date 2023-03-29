package com.petmuc.customer.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmailAddressTest {

    @Test
    @DisplayName("Given correct email When create Then email is correct ")
    void givenCorrectEmailWhenCreateThenEmailIsCorrect(){

        var testEmail =  "petertogara@gmail.com";
        EmailAddress  actualEmail =  EmailAddress.of(testEmail);
        Assertions.assertNotNull(actualEmail);
        Assertions.assertEquals(testEmail, actualEmail.getValue());


    }

    @Test
    @DisplayName("Given null email When create Then Nullpointer exception is thrown ")
    void givenNullEmailWhenCreateThenNullPointerExceptionIsThrown(){
        NullPointerException npe =  Assertions.assertThrows(NullPointerException.class,()->EmailAddress.of(null));
        Assertions.assertEquals("Email address should contain a value",npe.getMessage());
    }


}