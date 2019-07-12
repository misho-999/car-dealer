package com.angelov.cardealer.domain.dtos.exports.salesDiscounts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalesSalesDiscountsRootDto {

    @XmlElement(name = "sale")
    private List<SaleSalesDiscountsDto> saleSalesDiscountsDtos;

    public SalesSalesDiscountsRootDto() {
    }

    public List<SaleSalesDiscountsDto> getSaleSalesDiscountsDtos() {
        return saleSalesDiscountsDtos;
    }

    public void setSaleSalesDiscountsDtos(List<SaleSalesDiscountsDto> saleSalesDiscountsDtos) {
        this.saleSalesDiscountsDtos = saleSalesDiscountsDtos;
    }
}
