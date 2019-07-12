package com.angelov.cardealer.services.customer;

import com.angelov.cardealer.domain.dtos.exports.customersTotalSales.CustomersTotalSalesRootDto;
import com.angelov.cardealer.domain.dtos.exports.orderedCustomer.CustomOrderedCustomerRootDto;
import com.angelov.cardealer.domain.dtos.imports.customer.CustomerSeedRootDto;

import java.io.IOException;
import java.util.List;

public interface CustomerService {

    void seedCustomers(CustomerSeedRootDto customerSeedRootDto);

    CustomOrderedCustomerRootDto getOrderedCustomers() throws IOException;

    CustomersTotalSalesRootDto getAllCustomerWithLeastOneCar();

}
