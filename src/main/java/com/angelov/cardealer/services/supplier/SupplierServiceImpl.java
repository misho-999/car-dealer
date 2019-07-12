package com.angelov.cardealer.services.supplier;

import com.angelov.cardealer.domain.dtos.exports.localSuppliers.LocalSupplierDto;
import com.angelov.cardealer.domain.dtos.exports.localSuppliers.LocalSupplierRootDto;
import com.angelov.cardealer.domain.dtos.imports.supplier.SupplierSeedDto;
import com.angelov.cardealer.domain.dtos.imports.supplier.SupplierSeedRootDto;
import com.angelov.cardealer.domain.ennities.Supplier;
import com.angelov.cardealer.repositories.SupplierRepository;
import com.angelov.cardealer.util.CheckValidity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final CheckValidity checkValidity;
    private final ModelMapper modelMapper;
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(CheckValidity checkValidity, ModelMapper modelMapper, SupplierRepository supplierRepository) {
        this.checkValidity = checkValidity;
        this.modelMapper = modelMapper;
        this.supplierRepository = supplierRepository;
    }


    @Override
    public void seedSuppliers(SupplierSeedRootDto supplierSeedRootDto) {

        List<SupplierSeedDto> supplierSeedDtos = supplierSeedRootDto.getSupplierSeedDtos();

        for (SupplierSeedDto supplierSeedDto : supplierSeedDtos) {
            if (!this.checkValidity.isValid(supplierSeedDto)) {
                this.checkValidity.violations(supplierSeedDto)
                        .forEach(m -> System.out.println(m.getMessage()));

                continue;
            }

            Supplier supplier = this.modelMapper.map(supplierSeedDto, Supplier.class);
            this.supplierRepository.saveAndFlush(supplier);
        }
    }

    @Override
    public LocalSupplierRootDto getAllLocalSuppliers() {
        List<Supplier> allLocalSuppliers = this.supplierRepository.findAllLocalSuppliers();

        List<LocalSupplierDto> localSupplierDtos = new ArrayList<>();
        for (Supplier supplier : allLocalSuppliers) {

            LocalSupplierDto localSupplierDto = this.modelMapper.map(supplier, LocalSupplierDto.class);

            localSupplierDto.setPartsCount(supplier.getParts().size());
            localSupplierDtos.add(localSupplierDto);
        }

        LocalSupplierRootDto localSupplierRootDto = new LocalSupplierRootDto();
        localSupplierRootDto.setLocalSupplierDtos(localSupplierDtos);

        return localSupplierRootDto;
    }
}
