package ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.CoR;

import org.springframework.stereotype.Component;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.model.Order;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.model.Product;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.dop.PackagingService;

@Component
public class PackagingServiceCoR implements ChainOfResponsibility {
    private final PackagingService packagingService;

    public PackagingServiceCoR(PackagingService packagingService) {
        this.packagingService = packagingService;
    }

    @Override
    public void apply(Order order) {
        order.getProducts()
                .stream()
                .filter(Product::isFestivePackaging)
                .forEach(product -> packagingService.festivelyPack(product.getId(), order.getId()));
    }
}
