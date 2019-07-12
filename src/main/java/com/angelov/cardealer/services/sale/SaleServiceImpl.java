package com.angelov.cardealer.services.sale;

import com.angelov.cardealer.domain.dtos.exports.salesDiscounts.CarSalesDiscountsDto;
import com.angelov.cardealer.domain.dtos.exports.salesDiscounts.SaleSalesDiscountsDto;
import com.angelov.cardealer.domain.dtos.exports.salesDiscounts.SalesSalesDiscountsRootDto;
import com.angelov.cardealer.domain.dtos.imports.sale.SaleSeedDto;
import com.angelov.cardealer.domain.ennities.Car;
import com.angelov.cardealer.domain.ennities.Customer;
import com.angelov.cardealer.domain.ennities.Sale;
import com.angelov.cardealer.repositories.CarRepository;
import com.angelov.cardealer.repositories.CustomerRepository;
import com.angelov.cardealer.repositories.SaleReposiroty;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SaleServiceImpl implements SaleService {
    private final ModelMapper modelMapper;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final SaleReposiroty saleReposiroty;

    public SaleServiceImpl(ModelMapper modelMapper, CarRepository carRepository, CustomerRepository customerRepository, SaleReposiroty saleReposiroty) {
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.saleReposiroty = saleReposiroty;
    }

    @Override
    public void seedSales() {
        long count = this.carRepository.count();

        for (int i = 0; i < count; i++) {

            SaleSeedDto saleSeedDto = new SaleSeedDto();

            saleSeedDto.setCar(getRandomCar());
            saleSeedDto.setCustomer(getRandomCustomer());
            saleSeedDto.setDiscount(getRandomDiscount());

            Sale sale = this.modelMapper.map(saleSeedDto, Sale.class);
            this.saleReposiroty.saveAndFlush(sale);
        }

    }

    private Car getRandomCar() {
        Random random = new Random();

        int randomId = random.nextInt((int) this.carRepository.count() - 1) + 1;

        return this.carRepository.getOne(randomId);
    }

    private Customer getRandomCustomer() {
        Random random = new Random();

        int randomId = random.nextInt((int) this.customerRepository.count() - 1) + 1;

        return this.customerRepository.getOne(randomId);
    }

    private Integer getRandomDiscount() {
        //0%, 5%, 10%, 15%, 20%, 30%, 40% or 50%).
        int[] discounts = new int[]{0, 5, 10, 15, 20, 30, 40, 50};
        Random random = new Random();

        int randomDiscount = random.nextInt(8);

        return discounts[randomDiscount];
    }

    @Override
    public SalesSalesDiscountsRootDto getSalesDiscounst() {
        List<Sale> sales = this.saleReposiroty.findAll();

        List<SaleSalesDiscountsDto> saleSalesDiscountsDtos = new ArrayList<>();

        for (Sale sale : sales) {

            SaleSalesDiscountsDto saleSalesDiscountsDto = this.modelMapper.map(sale, SaleSalesDiscountsDto.class);

            CarSalesDiscountsDto carSalesDiscountsDto = this.modelMapper.map(sale.getCar(), CarSalesDiscountsDto.class);

            BigDecimal salePrice = this.getSumOfParts(sale.getId());
            double salePriceWithDiscount = salePrice.doubleValue() * (1-sale.getDiscount()/100);

            saleSalesDiscountsDto.setDiscount(sale.getDiscount()/100);
            saleSalesDiscountsDto.setCarSalesDiscountsDtos(carSalesDiscountsDto);
            saleSalesDiscountsDto.setPrice(salePrice);
            saleSalesDiscountsDto.setPriceWithDiscount(new BigDecimal(salePriceWithDiscount));

            saleSalesDiscountsDtos.add(saleSalesDiscountsDto);
        }

        SalesSalesDiscountsRootDto salesSalesDiscountsRootDto = new SalesSalesDiscountsRootDto();

        salesSalesDiscountsRootDto.setSaleSalesDiscountsDtos(saleSalesDiscountsDtos);

        return salesSalesDiscountsRootDto;
    }

    @Override
    public BigDecimal getSumOfParts(Integer carId) {

        Sale sale = this.saleReposiroty.findAllJoinToParts(carId);
        if (sale == null) {
            return new BigDecimal(0.0);
        }
        double sum = sale.getCar().getParts()
                .stream()
                .map(p -> p.getPrice().doubleValue())
                .mapToDouble(Double::doubleValue)
                .sum();

        return new BigDecimal(sum);
    }
}
