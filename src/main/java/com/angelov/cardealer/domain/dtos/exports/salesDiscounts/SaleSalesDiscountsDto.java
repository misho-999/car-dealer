package com.angelov.cardealer.domain.dtos.exports.salesDiscounts;


import com.angelov.cardealer.domain.ennities.Car;
import com.angelov.cardealer.domain.ennities.Customer;

import javax.persistence.Transient;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleSalesDiscountsDto {

    @XmlElement(name = "car")
    private CarSalesDiscountsDto carSalesDiscountsDtos;

    @XmlElement(name = "customer-name")
    private String customerName;

    @XmlElement(name = "discount")
    private Double discount;

    @XmlElement(name = "price")
    private BigDecimal price;

    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;


    public SaleSalesDiscountsDto() {
    }

    public CarSalesDiscountsDto getCarSalesDiscountsDtos() {
        return carSalesDiscountsDtos;
    }

    public void setCarSalesDiscountsDtos(CarSalesDiscountsDto carSalesDiscountsDtos) {
        this.carSalesDiscountsDtos = carSalesDiscountsDtos;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    }
