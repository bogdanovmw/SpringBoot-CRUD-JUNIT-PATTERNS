package ru.bogdanov.SpringBootCrudAndJunit.cache.exm2.service;

import ru.bogdanov.SpringBootCrudAndJunit.cache.exm2.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    Order create(Order user);
    Order createWithNameAndEmail(String name, String email);
    Order get(Long id);

    Order createOrReturnCached(Order order);
    Order createAndRefreshCache(Order order);

    void delete(Long id);
    void deleteAndEvict(Long id);
}
