package ru.bogdanov.SpringBootCrudAndJunit.patterns.builder.good;


public class App {
    public Truck testOne() {
        return Truck.builder()
                    .owner("owner")
                    .stsNumber("stsNumber")
                    .year(2022)
                    .trailer("trailer")
                    .weight(400)
                    .power(1000)
                    .mileage(0)
                .build();
    }

    public Truck testTwo() {
        return Truck.builder()
                    .owner("owner")
                    .stsNumber("stsNumber")
                    .year(2022)
                    .trailer("trailer")
                    .weight(400)
                    .power(1000)
                    .mileage(0)
                    .driver("Ivanov")
                .build();
    }

    public Truck testTree() {
        return Truck.builder()
                    .owner("owner")
                    .stsNumber("stsNumber")
                    .year(2022)
                    .trailer("trailer")
                    .weight(400)
                    .power(1000)
                    .mileage(0)
                    .driver("Ivanov")
                    .loadCapacity(20000)
                .build();
    }

}
