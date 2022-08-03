package ru.bogdanov.SpringBootCrudAndJunit.cache.exm2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bogdanov.SpringBootCrudAndJunit.cache.exm2.model.Order;

@Repository("TestRepository")
public interface OrderRepository extends JpaRepository<Order, Long> {
}
