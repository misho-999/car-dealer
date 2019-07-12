package com.angelov.cardealer.repositories;

import com.angelov.cardealer.domain.ennities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    @Query(value = "SELECT * FROM suppliers as s JOIN parts as p\n" +
            "ON s.id = p.supplier_id WHERE s.is_importer = FALSE GROUP BY s.id;", nativeQuery = true)
    List<Supplier> findAllLocalSuppliers();


}
