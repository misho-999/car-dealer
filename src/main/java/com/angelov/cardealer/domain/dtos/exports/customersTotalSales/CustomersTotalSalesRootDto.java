package com.angelov.cardealer.domain.dtos.exports.customersTotalSales;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersTotalSalesRootDto {

    @XmlElement(name = "customer")
    private List<CustomersTotalSalesDto> customersTotalSalesDtos;

    public CustomersTotalSalesRootDto() {
    }

    public List<CustomersTotalSalesDto> getCustomersTotalSalesDtos() {
        return customersTotalSalesDtos;
    }

    public void setCustomersTotalSalesDtos(List<CustomersTotalSalesDto> customersTotalSalesDtos) {
        this.customersTotalSalesDtos = customersTotalSalesDtos;
    }
}
