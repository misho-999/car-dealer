package com.angelov.cardealer.domain.dtos.imports.supplier;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierSeedRootDto {

    @XmlElement(name = "supplier")
    private List<SupplierSeedDto> supplierSeedDtos;

    public SupplierSeedRootDto() {
    }

    public List<SupplierSeedDto> getSupplierSeedDtos() {
        return supplierSeedDtos;
    }

    public void setSupplierSeedDtos(List<SupplierSeedDto> supplierSeedDtos) {
        this.supplierSeedDtos = supplierSeedDtos;
    }
}
