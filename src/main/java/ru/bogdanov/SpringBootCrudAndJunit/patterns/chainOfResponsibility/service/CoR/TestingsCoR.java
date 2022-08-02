package ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.CoR;

import org.springframework.stereotype.Component;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.model.Order;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.model.Product;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.dop.TestingsService;

@Component
public class TestingsCoR implements ChainOfResponsibility {
    private final TestingsService testingsService;

    public TestingsCoR(TestingsService testingsService) {
        this.testingsService = testingsService;
    }

    @Override
    public void apply(Order order) {
        order.getProducts()
                .stream()
                .filter(Product::isTesting)
                .forEach(product -> testingsService.testProduct(product.getId(), order.getId()));
    }
}
