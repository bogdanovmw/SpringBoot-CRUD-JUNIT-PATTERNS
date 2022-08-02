package ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service;

import org.springframework.stereotype.Component;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.model.Order;

@Component
public class OrderRepository {
    public void orderSave(Order order) {
        System.out.println("Save order: " + order);
    }
}
