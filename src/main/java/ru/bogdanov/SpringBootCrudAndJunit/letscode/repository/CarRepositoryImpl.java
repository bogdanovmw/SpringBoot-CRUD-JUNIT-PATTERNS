package ru.bogdanov.SpringBootCrudAndJunit.letscode.repository;

import ru.bogdanov.SpringBootCrudAndJunit.letscode.model.Car;

public class CarRepositoryImpl implements CarRepository {
    @Override
    public boolean saveCar(Car car) {
        System.out.println("Car save successfully!");
        return true;
    }

    @Override
    public Car findByName(String name) {
        return new Car();
    }

    @Override
    public Car findByActivateCode(String code) {
        return new Car();
    }
}
