package com.angelov.cardealer.web.controllers;

import com.angelov.cardealer.domain.dtos.exports.carsWithTheirListOfParts.CarWithTheirRootPartsDto;
import com.angelov.cardealer.domain.dtos.exports.customersTotalSales.CustomersTotalSalesRootDto;
import com.angelov.cardealer.domain.dtos.exports.localSuppliers.LocalSupplierRootDto;
import com.angelov.cardealer.domain.dtos.exports.orderedCustomer.CustomOrderedCustomerRootDto;
import com.angelov.cardealer.domain.dtos.exports.salesDiscounts.SalesSalesDiscountsRootDto;
import com.angelov.cardealer.domain.dtos.exports.toyotaCars.ToytaCarsRootDto;
import com.angelov.cardealer.domain.dtos.imports.car.CarSeedRootDto;
import com.angelov.cardealer.domain.dtos.imports.customer.CustomerSeedRootDto;
import com.angelov.cardealer.domain.dtos.imports.part.PartSeedRootDto;
import com.angelov.cardealer.domain.dtos.imports.supplier.SupplierSeedRootDto;
import com.angelov.cardealer.services.car.CarService;
import com.angelov.cardealer.services.customer.CustomerService;
import com.angelov.cardealer.services.part.PartService;
import com.angelov.cardealer.services.sale.SaleService;
import com.angelov.cardealer.services.supplier.SupplierService;
import com.angelov.cardealer.util.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;


@Controller
public class CarDealerController implements CommandLineRunner {
    private final static String CARS_JSON_FILE_PATH = "D:\\SOFTUNI\\JAVA\\JAVA DB\\02. HIBERNATE\\EXERCISES\\20.EXERCISE XML PROCESSING\\10. XML-Processing-Exercises\\carDealer\\src\\main\\resources\\imports\\xml\\cars.xml";
    private final static String CUSTOMERS_JSON_FILE_PATH = "D:\\SOFTUNI\\JAVA\\JAVA DB\\02. HIBERNATE\\EXERCISES\\20.EXERCISE XML PROCESSING\\10. XML-Processing-Exercises\\carDealer\\src\\main\\resources\\import\\xml\\customers.xml";
    public final static String PARTS_JSON_FILE_PATH = "D:\\SOFTUNI\\JAVA\\JAVA DB\\02. HIBERNATE\\EXERCISES\\20.EXERCISE XML PROCESSING\\10. XML-Processing-Exercises\\carDealer\\src\\main\\resources\\imports\\xml\\parts.xml";
    public final static String SUPPLIERS_JSON_FILE_PATH = "D:\\SOFTUNI\\JAVA\\JAVA DB\\02. HIBERNATE\\EXERCISES\\20.EXERCISE XML PROCESSING\\10. XML-Processing-Exercises\\carDealer\\src\\main\\resources\\imports\\xml\\suppliers.xml";

    private final CarService carService;
    private final CustomerService customerService;
    private final PartService partService;
    private final SupplierService supplierService;
    private final SaleService saleService;

    private final XmlParser xmlParser;

    @Autowired
    public CarDealerController(CarService carService, CustomerService customerService, PartService partService, SupplierService supplierService, SaleService saleService, XmlParser xmlParser) {
        this.carService = carService;
        this.customerService = customerService;
        this.partService = partService;
        this.supplierService = supplierService;
        this.saleService = saleService;

        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... args) throws Exception {

        //this.supplierService.seedSuppliers(this.xmlParser.parseXml(SupplierSeedRootDto.class, "D:\\SOFTUNI\\JAVA\\JAVA DB\\02. HIBERNATE\\EXERCISES\\20.EXERCISE XML PROCESSING\\10. XML-Processing-Exercises\\carDealer\\src\\main\\resources\\import\\xml\\suppliers.xml"));
        //this.partService.seedParts(this.xmlParser.parseXml(PartSeedRootDto.class, "D:\\SOFTUNI\\JAVA\\JAVA DB\\02. HIBERNATE\\EXERCISES\\20.EXERCISE XML PROCESSING\\10. XML-Processing-Exercises\\carDealer\\src\\main\\resources\\import\\xml\\parts.xml"));
        //this.carService.seedCars(this.xmlParser.parseXml(CarSeedRootDto.class, "D:\\SOFTUNI\\JAVA\\JAVA DB\\02. HIBERNATE\\EXERCISES\\20.EXERCISE XML PROCESSING\\10. XML-Processing-Exercises\\carDealer\\src\\main\\resources\\import\\xml\\cars.xml"));
        //this.customerService.seedCustomers(this.xmlParser.parseXml(CustomerSeedRootDto.class, "D:\\SOFTUNI\\JAVA\\JAVA DB\\02. HIBERNATE\\EXERCISES\\20.EXERCISE XML PROCESSING\\10. XML-Processing-Exercises\\carDealer\\src\\main\\resources\\import\\xml\\customers.xml"));
        //this.saleService.seedSales();

        //Query 1
        //exportOrderedCustomers();

        //Query 2
        //exportToyotaCars();

        //Query 3
        //exportLocalSuppliers();

        //Query 4
        //exportCarsWithTheirListOfParts();

        //Query 5
        //exportCustomerTotalSales();

        //Query 6
        exportSalesDiscounst();

    }


    //Query 1
    private void exportOrderedCustomers() throws IOException, JAXBException {
        CustomOrderedCustomerRootDto orderedCustomers = this.customerService.getOrderedCustomers();

        this.xmlParser.exportToXml(orderedCustomers, CustomOrderedCustomerRootDto.class, "D:\\SOFTUNI\\JAVA\\JAVA DB\\02. HIBERNATE\\EXERCISES\\20.EXERCISE XML PROCESSING\\10. XML-Processing-Exercises\\carDealer\\src\\main\\resources\\export\\xml\\ordered-customers.xml");
    }

    //Query 2
    private void exportToyotaCars() throws JAXBException {
        ToytaCarsRootDto cars = this.carService.getToyotaCars();

        this.xmlParser.exportToXml(cars, ToytaCarsRootDto.class, "D:\\SOFTUNI\\JAVA\\JAVA DB\\02. HIBERNATE\\EXERCISES\\20.EXERCISE XML PROCESSING\\10. XML-Processing-Exercises\\carDealer\\src\\main\\resources\\export\\xml\\toyota-cars.xml");
    }

    //Query 3
    private void exportLocalSuppliers() throws JAXBException {
        LocalSupplierRootDto allLocalSuppliers = this.supplierService.getAllLocalSuppliers();

        this.xmlParser.exportToXml(allLocalSuppliers, LocalSupplierRootDto.class, "D:\\SOFTUNI\\JAVA\\JAVA DB\\02. HIBERNATE\\EXERCISES\\20.EXERCISE XML PROCESSING\\10. XML-Processing-Exercises\\carDealer\\src\\main\\resources\\export\\xml\\local-suppliers.xml");
    }


    //Query 4
    private void exportCarsWithTheirListOfParts() throws JAXBException {
        CarWithTheirRootPartsDto cars = this.carService.getAllCarsWithTheirParts();

        this.xmlParser.exportToXml(cars, CarWithTheirRootPartsDto.class, "D:\\SOFTUNI\\JAVA\\JAVA DB\\02. HIBERNATE\\EXERCISES\\20.EXERCISE XML PROCESSING\\10. XML-Processing-Exercises\\carDealer\\src\\main\\resources\\export\\xml\\cars-and-parts.xml");
    }

    //Query 5
    private void exportCustomerTotalSales() throws JAXBException {
        CustomersTotalSalesRootDto customers = this.customerService.getAllCustomerWithLeastOneCar();

        this.xmlParser.exportToXml(customers, CustomersTotalSalesRootDto.class, "D:\\SOFTUNI\\JAVA\\JAVA DB\\02. HIBERNATE\\EXERCISES\\20.EXERCISE XML PROCESSING\\10. XML-Processing-Exercises\\carDealer\\src\\main\\resources\\export\\xml\\customers-total-sales.xml");
    }

    //Query 6
    private void exportSalesDiscounst() throws JAXBException {
        SalesSalesDiscountsRootDto sales = this.saleService.getSalesDiscounst();

        this.xmlParser.exportToXml(sales, SalesSalesDiscountsRootDto.class, "D:\\SOFTUNI\\JAVA\\JAVA DB\\02. HIBERNATE\\EXERCISES\\20.EXERCISE XML PROCESSING\\10. XML-Processing-Exercises\\carDealer\\src\\main\\resources\\export\\xml\\sales-discounts.xml");
    }
}
