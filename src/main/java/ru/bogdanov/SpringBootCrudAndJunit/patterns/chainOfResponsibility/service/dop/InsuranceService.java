package ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.dop;

import org.springframework.stereotype.Component;

@Component
public class InsuranceService {
    public void insure(String productId, String orderId) {
        System.out.println("Insure product: " + productId + " from order: " + orderId);
    }
}
