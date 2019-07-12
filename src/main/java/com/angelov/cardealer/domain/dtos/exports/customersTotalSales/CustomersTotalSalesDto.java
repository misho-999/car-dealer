package com.angelov.cardealer.domain.dtos.exports.customersTotalSales;

import com.angelov.cardealer.domain.ennities.Sale;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
    public class CustomersTotalSalesDto {

    @XmlAttribute(name = "full-name")
    private String fullName;

    @XmlAttribute(name = "bought-cars")
    private Integer boughtCars;

    @XmlAttribute(name = "spent-money")
    private BigDecimal spentMoney;

    @XmlTransient
    private List<Sale> sales;

    public CustomersTotalSalesDto() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getBoughtCars() {
        return boughtCars;
    }

    public void setBoughtCars(Integer boughtCars) {
        this.boughtCars = boughtCars;
    }

    public BigDecimal getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(BigDecimal spentMoney) {
        this.spentMoney = spentMoney;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
