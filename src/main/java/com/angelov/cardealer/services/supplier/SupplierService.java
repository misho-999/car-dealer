package com.angelov.cardealer.services.supplier;

import com.angelov.cardealer.domain.dtos.exports.localSuppliers.LocalSupplierRootDto;
import com.angelov.cardealer.domain.dtos.imports.supplier.SupplierSeedRootDto;

public interface SupplierService {

    void seedSuppliers(SupplierSeedRootDto supplierSeedRootDto);

    LocalSupplierRootDto getAllLocalSuppliers();
}
