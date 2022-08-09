package ru.bogdanov.SpringBootCrudAndJunit.letscode.service;

import ru.bogdanov.SpringBootCrudAndJunit.letscode.model.Car;

public interface CarService {
    boolean addCar(Car car);
    boolean activeCar(String code);
}
