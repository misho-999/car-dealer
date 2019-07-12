package com.angelov.cardealer.domain.dtos.exports.carsWithTheirListOfParts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWithTheirRootPartsDto {

    @XmlElement(name = "car")
    private List<CarWithTheirPartsDto> carWithTheirPartDtos;

    public CarWithTheirRootPartsDto() {
    }

    public List<CarWithTheirPartsDto> getCarWithTheirPartDtos() {
        return carWithTheirPartDtos;
    }

    public void setCarWithTheirPartDtos(List<CarWithTheirPartsDto> carWithTheirPartDtos) {
        this.carWithTheirPartDtos = carWithTheirPartDtos;
    }
}
