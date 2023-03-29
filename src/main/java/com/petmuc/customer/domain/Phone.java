package com.petmuc.customer.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.Embeddable;
import java.util.Objects;
import java.util.regex.Pattern;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Phone {

    private String value;

    private Phone(String value) {
        this.value = value;
    }

    public static Phone of(final String value) {
        Objects.requireNonNull(value, "Phone number should contain a value");
        Assert.isTrue(!value.isBlank(), "Phone number can not be blank");
        final String regexPattern
                = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
        boolean matches = Pattern.compile(regexPattern).matcher(value).matches();
        Assert.isTrue(matches, "Invalid phone number");
        return new Phone(value);
    }

}
