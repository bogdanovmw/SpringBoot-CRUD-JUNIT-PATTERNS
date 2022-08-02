package ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.dop;

import org.springframework.stereotype.Component;

@Component
public class PackagingService {
    public void festivelyPack(String productId, String orderId) {
        System.out.println("Festively pack product: " + productId + " from order: " + orderId);
    }
}
