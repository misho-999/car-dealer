package com.angelov.cardealer.domain.dtos.exports.carsWithTheirListOfParts;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWithTheirPartsDto {

    @XmlAttribute(name = "make")
    private String make;

    @XmlAttribute(name = "model")
    private String model;

    @XmlAttribute(name = "travelled-distance")
    private Long travelledDistance;

    @XmlElement(name = "parts")
    private PartsCarWithTheirRootPartsDto parsCarWithTheirRootPartDtos;

    public CarWithTheirPartsDto() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public PartsCarWithTheirRootPartsDto getParsCarWithTheirRootPartDtos() {
        return parsCarWithTheirRootPartDtos;
    }

    public void setParsCarWithTheirRootPartDtos(PartsCarWithTheirRootPartsDto parsCarWithTheirRootPartDtos) {
        this.parsCarWithTheirRootPartDtos = parsCarWithTheirRootPartDtos;
    }
}
