package ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.CoR;

import org.springframework.stereotype.Component;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.model.Order;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.model.Product;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.dop.InsuranceService;

@Component
public class InsuranceServiceCoR implements ChainOfResponsibility {
    private final InsuranceService insuranceService;

    public InsuranceServiceCoR(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @Override
    public void apply(Order order) {
        order.getProducts()
                .stream()
                .filter(Product::isInsurance)
                .forEach(product -> insuranceService.insure(product.getId(), order.getId()));
    }
}
