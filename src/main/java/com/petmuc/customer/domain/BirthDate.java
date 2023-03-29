package com.petmuc.customer.domain;

import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BirthDate {

    private LocalDate value;

    private BirthDate(LocalDate value) {
        this.value = value;
    }

    public static BirthDate of(final LocalDate value) {
        Objects.requireNonNull(value, "Birth date should contain a value");
        Assert.isTrue(value.isAfter(LocalDate.now()), "Birth date can not be in the future");

        return new BirthDate(value);
    }
}
