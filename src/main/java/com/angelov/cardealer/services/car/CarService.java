package com.angelov.cardealer.services.car;

import com.angelov.cardealer.domain.dtos.exports.carsWithTheirListOfParts.CarWithTheirRootPartsDto;
import com.angelov.cardealer.domain.dtos.exports.toyotaCars.ToytaCarsRootDto;
import com.angelov.cardealer.domain.dtos.imports.car.CarSeedRootDto;
import com.angelov.cardealer.domain.ennities.Car;

public interface CarService {

    void seedCars(CarSeedRootDto carSeedRootDto);

    ToytaCarsRootDto getToyotaCars();

    CarWithTheirRootPartsDto getAllCarsWithTheirParts();

}
