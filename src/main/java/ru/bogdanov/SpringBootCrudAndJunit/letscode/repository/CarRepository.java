package ru.bogdanov.SpringBootCrudAndJunit.letscode.repository;

import ru.bogdanov.SpringBootCrudAndJunit.letscode.model.Car;

public interface CarRepository {
    boolean saveCar(Car car);
    Car findByName(String name);
    Car findByActivateCode(String code);
}
