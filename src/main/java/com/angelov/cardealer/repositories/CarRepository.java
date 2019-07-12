package com.angelov.cardealer.repositories;

import com.angelov.cardealer.domain.dtos.exports.toyotaCars.ToytaCarsRootDto;
import com.angelov.cardealer.domain.ennities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query(value = "SELECT * FROM cars as c WHERE make= \"Toyota\"\n" +
            "ORDER BY c.model, c.travelled_distance DESC", nativeQuery = true)
    List<Car> findToyotaCasr();

    @Query(value = "SELECT * FROM cars as c JOIN parts_cars as pc\n" +
            "on c.id = pc.car_id JOIN parts as p on p.id = pc.part_id", nativeQuery = true)
    List<Car> findAllCarsWithTheirParts();




}
