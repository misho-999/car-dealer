package com.angelov.cardealer.domain.dtos.exports.orderedCustomer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomOrderedCustomerRootDto {

    @XmlElement(name = "customer")
    private List<CustomOrderedCustomerDto> customOrderedCustomerDtos;

    public CustomOrderedCustomerRootDto() {
    }

    public List<CustomOrderedCustomerDto> getCustomOrderedCustomerDtos() {
        return customOrderedCustomerDtos;
    }

    public void setCustomOrderedCustomerDtos(List<CustomOrderedCustomerDto> customOrderedCustomerDtos) {
        this.customOrderedCustomerDtos = customOrderedCustomerDtos;
    }
}
