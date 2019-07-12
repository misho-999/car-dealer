package com.angelov.cardealer.domain.dtos.exports.toyotaCars;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class ToytaCarsRootDto {

    @XmlElement(name = "car")
    private List<ToytaCarsDto> toytaCarsDtos;

    public ToytaCarsRootDto() {
    }

    public List<ToytaCarsDto> getToytaCarsDtos() {
        return toytaCarsDtos;
    }

    public void setToytaCarsDtos(List<ToytaCarsDto> toytaCarsDtos) {
        this.toytaCarsDtos = toytaCarsDtos;
    }
}
