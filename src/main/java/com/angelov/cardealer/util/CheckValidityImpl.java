package com.angelov.cardealer.util;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public class CheckValidityImpl implements CheckValidity {
    private final Validator validator;

    @Autowired
    public CheckValidityImpl(Validator validator) {
        this.validator = validator;
    }


    @Override
    public <E> boolean isValid(E entity) {
        return this.validator.validate(entity).size() == 0;
    }

    @Override
    public <E> Set<ConstraintViolation<E>> violations(E entity) {

        return validator.validate(entity);
    }
}
