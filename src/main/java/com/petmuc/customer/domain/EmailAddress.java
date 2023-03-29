package com.petmuc.customer.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.util.Objects;
import java.util.regex.Pattern;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailAddress {
    @Column(name = "email_address")
    private String value;

    private EmailAddress(String value) {
        this.value = value;
    }

    public static EmailAddress of(final String value) {
        Objects.requireNonNull(value, "Email address should contain a value");
        Assert.isTrue(!value.isBlank(), "Email address can not be blank");
        final String regexPattern = "^(.+)@(\\S+)$";
        boolean matches = Pattern.compile(regexPattern).matcher(value).matches();
        Assert.isTrue(matches, "Invalid email address");
        return new EmailAddress(value);
    }

}
