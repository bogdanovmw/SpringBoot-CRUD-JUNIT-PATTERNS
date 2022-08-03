package ru.bogdanov.SpringBootCrudAndJunit.cache.exm2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ru.bogdanov.SpringBootCrudAndJunit.cache.exm2.model.Order;
import ru.bogdanov.SpringBootCrudAndJunit.cache.exm2.repo.OrderRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service("TestService")
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Qualifier("TestRepository")
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository userRepository) {
        this.orderRepository = userRepository;
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order create(Order user) {
        return orderRepository.save(user);
    }

    @Override
    @Cacheable(value = "order", key = "#name")
    public Order createWithNameAndEmail(String name, String email) {
        log.info("create order with parameters: {}, {}", name, email);
        return orderRepository.save(new Order(name, email));
    }

    @Override
    @Cacheable("order")
    public Order get(Long id) {
        log.info("getting order by id: {}", id);
        return orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found by id: " + id));
    }

    @Override
    @Cacheable(value = "order", key = "#order.name")
    public Order createOrReturnCached(Order order) {
        log.info("creating order: {}", order);
        return orderRepository.save(order);
    }

    @Override
    @CachePut(value = "order", key = "#order.name")
    public Order createAndRefreshCache(Order order) {
        log.info("creating order: {}", order);
        return orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        log.info("deleting order by id: {}", id);
        orderRepository.deleteById(id);
    }

    @Override
    @CacheEvict("users")
    public void deleteAndEvict(Long id) {
        log.info("deleting order by id: {}", id);
        orderRepository.deleteById(id);
    }

    @Caching(
            cacheable = {
                    @Cacheable("users"),
                    @Cacheable("contacts")
            },
            put = {
                    @CachePut("tables"),
                    @CachePut("chairs"),
                    @CachePut(value = "meals", key = "#user.email")
            },
            evict = {
                    @CacheEvict(value = "services", key = "#user.name")
            }
    )
    public void cacheExample(Order Order) {
    }
}


