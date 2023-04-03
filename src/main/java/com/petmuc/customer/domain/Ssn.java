package com.petmuc.customer.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ssn {
    @Column(name = "ssn")
    private Integer value;

    private Ssn(Integer ssn) {
        this.value = ssn;
    }

    public static Ssn create(final Integer value) {
        Objects.requireNonNull(value, "Social Security Number should not be null");
        Assert.isTrue(String.valueOf(value).toCharArray().length == 9, "The social security number should have 9 characters");
        return new Ssn(value);
    }
}