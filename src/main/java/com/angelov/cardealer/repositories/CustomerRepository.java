package com.angelov.cardealer.repositories;

import com.angelov.cardealer.domain.ennities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    @Query(value = "SELECT * FROM customers as c ORDER BY c.birth_date, c.is_young_driver DESC", nativeQuery = true)
    List<Customer> findAllCustumersOrderedByBirthDate();

    @Query(value = "SELECT * from customers as c JOIN sales as s\n" +
            "on c.id = s.custumer_id JOIN cars as ca\n" +
            "on\ts.car_id = ca.id WHERE ca.id is not NULL GROUP BY c.id", nativeQuery = true)
    List<Customer> findAllCustomerWithLeastOneCar();

}
