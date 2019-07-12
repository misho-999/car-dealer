package com.angelov.cardealer.domain.dtos.exports.localSuppliers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "supliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalSupplierRootDto {

    @XmlElement(name = "suplier")
    private List<LocalSupplierDto> localSupplierDtos;

    public LocalSupplierRootDto() {
    }

    public List<LocalSupplierDto> getLocalSupplierDtos() {
        return localSupplierDtos;
    }

    public void setLocalSupplierDtos(List<LocalSupplierDto> localSupplierDtos) {
        this.localSupplierDtos = localSupplierDtos;
    }
}
