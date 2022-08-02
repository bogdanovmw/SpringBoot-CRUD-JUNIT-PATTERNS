package ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.model.Order;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.OrderServiceWithCoR;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.OrderServiceWithoutCor;

@RestController
@RequestMapping("/order")
public class Controller {
    private final OrderServiceWithoutCor orderServiceWithoutCor;
    private final OrderServiceWithCoR orderServiceWithCoR;

    public Controller(OrderServiceWithoutCor orderServiceWithoutCor, OrderServiceWithCoR orderServiceWithCoR) {
        this.orderServiceWithoutCor = orderServiceWithoutCor;
        this.orderServiceWithCoR = orderServiceWithCoR;
    }


    @PostMapping
    public boolean createOrder(@RequestBody Order order) {
        return orderServiceWithCoR.createOrder(order);
    }
}
