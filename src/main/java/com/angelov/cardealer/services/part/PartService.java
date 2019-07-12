package com.angelov.cardealer.services.part;

import com.angelov.cardealer.domain.dtos.imports.part.PartSeedRootDto;

public interface PartService {

   void seedParts(PartSeedRootDto partSeedRootDto);

    Integer getSumOfPricesAllByCarId(Integer partId);
}
