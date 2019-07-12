package com.angelov.cardealer.services.customer;

import com.angelov.cardealer.domain.dtos.exports.customersTotalSales.CustomersTotalSalesDto;
import com.angelov.cardealer.domain.dtos.exports.customersTotalSales.CustomersTotalSalesRootDto;
import com.angelov.cardealer.domain.dtos.exports.orderedCustomer.CustomOrderedCustomerDto;
import com.angelov.cardealer.domain.dtos.exports.orderedCustomer.CustomOrderedCustomerRootDto;
import com.angelov.cardealer.domain.dtos.imports.customer.CustomerSeedDto;
import com.angelov.cardealer.domain.dtos.imports.customer.CustomerSeedRootDto;
import com.angelov.cardealer.domain.ennities.Customer;
import com.angelov.cardealer.domain.ennities.Sale;
import com.angelov.cardealer.repositories.CustomerRepository;
import com.angelov.cardealer.services.part.PartService;
import com.angelov.cardealer.util.CheckValidity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CheckValidity checkValidity;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;
    private final PartService partService;

    public CustomerServiceImpl(CheckValidity checkValidity, ModelMapper modelMapper, CustomerRepository customerRepository, PartService partService) {
        this.checkValidity = checkValidity;
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;

        this.partService = partService;
    }

    @Override
    public void seedCustomers(CustomerSeedRootDto customerSeedRootDto) {

        List<CustomerSeedDto> customerSeedDtos = customerSeedRootDto.getCustomerSeedDtos();

        for (CustomerSeedDto customerSeedDto : customerSeedDtos) {
            if (!this.checkValidity.isValid(customerSeedDto)) {
                this.checkValidity.violations(customerSeedDto)
                        .forEach(m -> System.out.println(m.getMessage()));

                continue;
            }

            Customer customert = this.modelMapper.map(customerSeedDto, Customer.class);
            this.customerRepository.saveAndFlush(customert);
        }
    }

    @Override
    public CustomOrderedCustomerRootDto getOrderedCustomers() throws IOException {

        List<Customer> allCustumersOrderedByBirthDate = this.customerRepository.findAllCustumersOrderedByBirthDate();

        List<CustomOrderedCustomerDto> customOrderedCustomerDtos = new ArrayList<>();

        for (Customer customer : allCustumersOrderedByBirthDate) {

            CustomOrderedCustomerDto customOrderedCustomerDto = this.modelMapper.map(customer, CustomOrderedCustomerDto.class);

            customOrderedCustomerDtos.add(customOrderedCustomerDto);
        }

        CustomOrderedCustomerRootDto customOrderedCustomerRootDto = new CustomOrderedCustomerRootDto();
        customOrderedCustomerRootDto.setCustomOrderedCustomerDtos(customOrderedCustomerDtos);

        return customOrderedCustomerRootDto;
    }

    @Override
    public CustomersTotalSalesRootDto getAllCustomerWithLeastOneCar() {
        List<Customer> customers = this.customerRepository.findAllCustomerWithLeastOneCar();

        List<CustomersTotalSalesDto> customersTotalSalesDtos = new ArrayList<>();
        for (Customer customer : customers) {
            CustomersTotalSalesDto customersTotalSalesDto = this.modelMapper.map(customer, CustomersTotalSalesDto.class);

            int sum = customer.getSales()
                    .stream()
                    .map(Sale::getCar)
                    .map(c -> this.partService.getSumOfPricesAllByCarId(c.getId()))
                    .mapToInt(Integer::intValue)
                    .sum();

            customersTotalSalesDto.setFullName(customer.getName());
            customersTotalSalesDto.setBoughtCars(customer.getSales().size());
            customersTotalSalesDto.setSpentMoney(new BigDecimal(sum));

            customersTotalSalesDtos.add(customersTotalSalesDto);
        }

        List<CustomersTotalSalesDto> customersTotalSalesDtosSorted = customersTotalSalesDtos.stream()
                .sorted((e1, e2) -> {
                    int result = e2.getSpentMoney().intValue() - e1.getSpentMoney().intValue();

                    if (result == 0) {
                        result = e2.getBoughtCars() - e1.getBoughtCars();
                    }

                    return result;
                }).collect(Collectors.toList());


        CustomersTotalSalesRootDto customersTotalSalesRootDto = new CustomersTotalSalesRootDto();
        customersTotalSalesRootDto.setCustomersTotalSalesDtos(customersTotalSalesDtosSorted);

        return customersTotalSalesRootDto;
    }
}
