package com.angelov.cardealer.services.part;

import com.angelov.cardealer.domain.dtos.imports.part.PartSeedDto;
import com.angelov.cardealer.domain.dtos.imports.part.PartSeedRootDto;
import com.angelov.cardealer.domain.ennities.Part;
import com.angelov.cardealer.domain.ennities.Supplier;
import com.angelov.cardealer.repositories.PartRepository;
import com.angelov.cardealer.repositories.SupplierRepository;
import com.angelov.cardealer.util.CheckValidity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PartServiceImpl implements PartService {
    private final CheckValidity checkValidity;
    private final ModelMapper modelMapper;
    private final PartRepository partRepository;
    private final SupplierRepository supplierRepository;

    public PartServiceImpl(CheckValidity checkValidity, ModelMapper modelMapper, PartRepository partRepository, SupplierRepository supplierRepository) {
        this.checkValidity = checkValidity;
        this.modelMapper = modelMapper;
        this.partRepository = partRepository;

        this.supplierRepository = supplierRepository;
    }

    @Override
    public void seedParts(PartSeedRootDto partSeedRootDto) {

        List<PartSeedDto> partSeedDtos = partSeedRootDto.getPartSeedDtos();

        for (PartSeedDto partsSeedDto : partSeedDtos) {
            if (!this.checkValidity.isValid(partsSeedDto)) {
                this.checkValidity.violations(partsSeedDto)
                        .forEach(m -> System.out.println(m.getMessage()));

                continue;
            }

            partsSeedDto.setSupplier(randomSupplier());

            Part part = this.modelMapper.map(partsSeedDto, Part.class);
            this.partRepository.saveAndFlush(part);
        }
    }

    public Supplier randomSupplier() {
        Random random = new Random();

        int randomId = random.nextInt((int) this.supplierRepository.count() - 1) + 1;

        return this.supplierRepository.getOne(randomId);
    }

    @Override
    public Integer getSumOfPricesAllByCarId(Integer partId) {

        List<Part> parts = this.partRepository.findAllByCarId(partId);

        int sum = parts.stream()
                .map(Part::getPrice)
                .map(p-> p.intValue())
                .mapToInt(Integer::intValue)
                .sum();

        return sum;
    }
}
