package com.angelov.cardealer.repositories;

import com.angelov.cardealer.domain.ennities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleReposiroty extends JpaRepository<Sale, Integer> {


    @Query(value = "SELECT * FROM sales as s\n" +
            "JOIN cars as c\n" +
            "on c.id = s.car_id\n" +
            "JOIN parts_cars as pc\n" +
            "on pc.car_id = c.id\n" +
            "JOIN parts as p\n" +
            "on p.id = pc.part_id\n" +
            "where s.id = ?", nativeQuery = true)
    Sale findAllJoinToParts(Integer saleId);
}
