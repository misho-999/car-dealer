package com.angelov.cardealer.repositories;

import com.angelov.cardealer.domain.ennities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {

    @Query(value = "SELECT * FROM cars as c\n" +
            "JOIN parts_cars as pc\n" +
            "on c.id = pc.car_id\n" +
            "JOIN parts as p\n" +
            "on p.id = pc.part_id\n" +
            "WHERE p.id = ?", nativeQuery = true)
    List<Part> findAllByCarId(Integer carId);
}
