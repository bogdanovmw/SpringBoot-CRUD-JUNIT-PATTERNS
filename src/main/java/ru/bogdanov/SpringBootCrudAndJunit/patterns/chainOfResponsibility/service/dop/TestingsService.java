package ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.dop;

import org.springframework.stereotype.Component;

@Component
public class TestingsService {
    public void testProduct(String productId, String orderId) {
        System.out.println("Testing product: " + productId + " from order: " + orderId);
    }
}
