package ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service;

import org.springframework.stereotype.Service;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.model.Order;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.CoR.ChainOfResponsibility;

import java.util.List;

@Service
public class OrderServiceWithCoR {
    private final OrderRepository orderRepository;
    private final List<ChainOfResponsibility> chains;

    public OrderServiceWithCoR(OrderRepository orderRepository, List<ChainOfResponsibility> chains) {
        this.orderRepository = orderRepository;
        this.chains = chains;
    }

    public boolean createOrder(Order order) {
        orderRepository.orderSave(order);

        // Берем каждую реализацию CoR и если условие совпадает выполняем
        chains.forEach(chain -> chain.apply(order));

        return true;
    }
}
