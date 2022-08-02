package ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.CoR;

import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.model.Order;

public interface ChainOfResponsibility {
    void apply(Order order);
}
