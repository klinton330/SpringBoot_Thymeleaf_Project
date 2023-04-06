package com.webapps.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProfessionValidator implements ConstraintValidator<Profession,String> {

    @Override
    public boolean isValid(String profession, ConstraintValidatorContext constraintValidatorContext) {
        return !profession.equalsIgnoreCase("default");
    }
}
