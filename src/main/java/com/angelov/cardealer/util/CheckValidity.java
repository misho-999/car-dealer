package com.angelov.cardealer.util;

import org.hibernate.exception.spi.ViolatedConstraintNameExtracter;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface CheckValidity {
    <E> boolean isValid(E entity);

    <E> Set<ConstraintViolation<E>> violations(E emtity);
}
