package com.petmuc.customer.domain;

import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.util.Objects;

@Getter   //to get our value
@Embeddable   //to be able to persist it as a column in the aggregator
@NoArgsConstructor(access = AccessLevel.PROTECTED)   // hibernate needs it
public class FirstName {

    private String value;

    private FirstName(String value) {
        this.value = value;
    }

    public static FirstName of(final String value) {
        Objects.requireNonNull(value, "First name can not be null");
        Assert.isTrue(!value.isBlank(), "First name can not be blank");

        return new FirstName(value);
    }

}
