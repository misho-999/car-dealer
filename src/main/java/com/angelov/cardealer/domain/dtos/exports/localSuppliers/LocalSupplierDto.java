package com.angelov.cardealer.domain.dtos.exports.localSuppliers;


import com.angelov.cardealer.domain.ennities.Part;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "suplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalSupplierDto {

    @XmlAttribute(name = "id")
    private Integer id;

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "parts-count")
    private Integer partsCount;

    @XmlTransient
    private List<Part> parts;

    public LocalSupplierDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public Integer getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(Integer partsCount) {
        this.partsCount = partsCount;
    }


}
