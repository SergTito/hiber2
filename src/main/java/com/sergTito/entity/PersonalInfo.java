package com.sergTito.entity;

import com.sergTito.converter.BirthdayConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class PersonalInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String firstname;
    private String lastname;

    @Convert(converter = BirthdayConverter.class) // либо тут либо в раннере
    private Birthday birthDate;
}
