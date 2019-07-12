package com.angelov.cardealer.domain.dtos.imports.customer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerSeedRootDto {

    @XmlElement(name = "customer")
    private List<CustomerSeedDto> customerSeedDtos;

    public CustomerSeedRootDto() {
    }

    public List<CustomerSeedDto> getCustomerSeedDtos() {
        return customerSeedDtos;
    }

    public void setCustomerSeedDtos(List<CustomerSeedDto> customerSeedDtos) {
        this.customerSeedDtos = customerSeedDtos;
    }
}
