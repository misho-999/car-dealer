package com.angelov.cardealer.domain.dtos.exports.carsWithTheirListOfParts;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartsCarWithTheirRootPartsDto {

    @XmlElement(name = "part")
    private List<PartCarWithTheirPartsDto> parsCarWithTheirPartDtos;

    public PartsCarWithTheirRootPartsDto() {
    }

    public List<PartCarWithTheirPartsDto> getParsCarWithTheirPartDtos() {
        return parsCarWithTheirPartDtos;
    }

    public void setParsCarWithTheirPartDtos(List<PartCarWithTheirPartsDto> parsCarWithTheirPartDtos) {
        this.parsCarWithTheirPartDtos = parsCarWithTheirPartDtos;
    }
}
