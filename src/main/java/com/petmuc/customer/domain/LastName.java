package com.petmuc.customer.domain;

import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LastName {

    private String value;

    private LastName(String value) {
        this.value = value;
    }

    public static LastName of(final String value) {

        Objects.requireNonNull(value, "Last name should contain value");
        Assert.isTrue(!value.isBlank(), "Last name can not be blank");

        return new LastName(value);
    }
}
