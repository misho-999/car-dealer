package com.angelov.cardealer.services.car;

import com.angelov.cardealer.domain.dtos.exports.carsWithTheirListOfParts.CarWithTheirPartsDto;
import com.angelov.cardealer.domain.dtos.exports.carsWithTheirListOfParts.CarWithTheirRootPartsDto;
import com.angelov.cardealer.domain.dtos.exports.carsWithTheirListOfParts.PartCarWithTheirPartsDto;
import com.angelov.cardealer.domain.dtos.exports.carsWithTheirListOfParts.PartsCarWithTheirRootPartsDto;
import com.angelov.cardealer.domain.dtos.exports.toyotaCars.ToytaCarsDto;
import com.angelov.cardealer.domain.dtos.exports.toyotaCars.ToytaCarsRootDto;
import com.angelov.cardealer.domain.dtos.imports.car.CarSeedDto;
import com.angelov.cardealer.domain.dtos.imports.car.CarSeedRootDto;
import com.angelov.cardealer.domain.ennities.Car;
import com.angelov.cardealer.domain.ennities.Part;
import com.angelov.cardealer.repositories.CarRepository;
import com.angelov.cardealer.repositories.PartRepository;
import com.angelov.cardealer.util.CheckValidity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarServiceImpl implements CarService {
    private final CheckValidity checkValidity;
    private final ModelMapper modelMapper;
    private final CarRepository carRepository;
    private final PartRepository partRepository;

    @Autowired
    public CarServiceImpl(CheckValidity checkValidity, ModelMapper modelMapper, CarRepository carRepository, PartRepository partRepository) {
        this.checkValidity = checkValidity;
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
        this.partRepository = partRepository;
    }


    @Override
    public void seedCars(CarSeedRootDto carSeedRootDto) {

        List<CarSeedDto> carSeedDtos = carSeedRootDto.getCarSeedDtos();

        for (CarSeedDto carSeedDto : carSeedDtos) {
            if (!this.checkValidity.isValid(carSeedDto)) {
                this.checkValidity.violations(carSeedDto)
                        .forEach(m -> System.out.println(m.getMessage()));

                continue;
            }

            carSeedDto.setParts(this.getRandomParts());

            Car car = this.modelMapper.map(carSeedDto, Car.class);
            this.carRepository.saveAndFlush(car);
        }

    }

    private List<Part> getRandomParts() {

        List<Part> parts = new ArrayList<>();

        Random random = new Random();

        int size = random.nextInt(10) + 10;

        for (int i = 0; i < size; i++) {
            parts.add(getRandomPart());
        }

        return parts;
    }

    private Part getRandomPart() {
        Random random = new Random();

        int partId = random.nextInt((int) this.partRepository.count() - 1) + 1;

        return this.partRepository.getOne(partId);
    }

    @Override
    public ToytaCarsRootDto getToyotaCars() {
        List<Car> cars = this.carRepository.findToyotaCasr();

        List<ToytaCarsDto> toytaCarsDtos = new ArrayList<>();

        for (Car car : cars) {

            ToytaCarsDto toytaCarsDto = this.modelMapper.map(car, ToytaCarsDto.class);

            toytaCarsDtos.add(toytaCarsDto);
        }

        ToytaCarsRootDto toytaCarsRootDto = new ToytaCarsRootDto();
        toytaCarsRootDto.setToytaCarsDtos(toytaCarsDtos);

        return toytaCarsRootDto;
    }

    @Override
    public CarWithTheirRootPartsDto getAllCarsWithTheirParts() {
        List<Car> cars = this.carRepository.findAllCarsWithTheirParts();

        List<CarWithTheirPartsDto> carWithTheirPartsDtos = new ArrayList<>();

        for (Car car : cars) {
            CarWithTheirPartsDto carWithTheirPartsDto = this.modelMapper.map(car, CarWithTheirPartsDto.class);

            List<PartCarWithTheirPartsDto> partCarWithTheirPartsDtos = new ArrayList<>();

            for (Part part : car.getParts()) {

                PartCarWithTheirPartsDto partCarWithTheirPartsDto = this.modelMapper.map(part, PartCarWithTheirPartsDto.class);

                partCarWithTheirPartsDtos.add(partCarWithTheirPartsDto);
            }

            PartsCarWithTheirRootPartsDto partsCarWithTheirRootPartsDto = new PartsCarWithTheirRootPartsDto();
            partsCarWithTheirRootPartsDto.setParsCarWithTheirPartDtos(partCarWithTheirPartsDtos);

            carWithTheirPartsDto.setParsCarWithTheirRootPartDtos(partsCarWithTheirRootPartsDto);

            carWithTheirPartsDtos.add(carWithTheirPartsDto);
        }

        CarWithTheirRootPartsDto carWithTheirRootPartsDto = new CarWithTheirRootPartsDto();
        carWithTheirRootPartsDto.setCarWithTheirPartDtos(carWithTheirPartsDtos);

        return carWithTheirRootPartsDto;
    }


}
