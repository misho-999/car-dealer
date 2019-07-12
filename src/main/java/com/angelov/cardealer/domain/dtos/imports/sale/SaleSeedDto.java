package com.angelov.cardealer.domain.dtos.imports.sale;

import com.angelov.cardealer.domain.ennities.Car;
import com.angelov.cardealer.domain.ennities.Customer;
import com.angelov.cardealer.domain.ennities.Sale;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class SaleSeedDto implements Serializable {
    @Expose
    private Integer discount;

    @Expose
    private Customer customer;

    @Expose
    private Car car;

    public SaleSeedDto() {
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
