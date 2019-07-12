package com.angelov.cardealer.services.sale;

import com.angelov.cardealer.domain.dtos.exports.salesDiscounts.SalesSalesDiscountsRootDto;

import java.math.BigDecimal;

public interface SaleService {

    void seedSales();


    SalesSalesDiscountsRootDto getSalesDiscounst();

   BigDecimal getSumOfParts(Integer carId);

}
