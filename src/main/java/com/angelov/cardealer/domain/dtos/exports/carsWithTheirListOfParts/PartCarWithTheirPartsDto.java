package com.angelov.cardealer.domain.dtos.exports.carsWithTheirListOfParts;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.reflect.Field;

@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartCarWithTheirPartsDto {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "price")
    private String price;

    public PartCarWithTheirPartsDto() {
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
}
