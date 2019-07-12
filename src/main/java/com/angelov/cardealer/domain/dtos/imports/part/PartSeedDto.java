package com.angelov.cardealer.domain.dtos.imports.part;

import com.angelov.cardealer.domain.ennities.Supplier;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartSeedDto {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "price")
    private String price;

    @XmlAttribute(name = "quantity")
    private Integer quantity;

    @XmlTransient
    private Supplier supplier;

    public PartSeedDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
