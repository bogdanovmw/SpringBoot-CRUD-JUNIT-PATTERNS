package ru.bogdanov.SpringBootCrudAndJunit.patterns.builder.bad;

public class Track {
    private final String owner;
    private final String stsNumber;
    private final int year;
    private final String trailer;
    private final int weight;
    private final int power;
    private final int mileage;
    private final String driver;
    private final int loadCapacity;

    public Track(String owner, String stsNumber, int year, String trailer, int weight, int power, int mileage) {
        this.owner = owner;
        this.stsNumber = stsNumber;
        this.year = year;
        this.trailer = trailer;
        this.weight = weight;
        this.power = power;
        this.mileage = mileage;
        this.driver = null;
        this.loadCapacity = 0;
    }

    public Track(String owner, String stsNumber, int year, String trailer, int weight, int power, int mileage, String driver) {
        this.owner = owner;
        this.stsNumber = stsNumber;
        this.year = year;
        this.trailer = trailer;
        this.weight = weight;
        this.power = power;
        this.mileage = mileage;
        this.driver = driver;
        this.loadCapacity = 0;
    }

    public Track(String owner, String stsNumber, int year, String trailer, int weight, int power, int mileage, String driver, int loadCapacity) {
        this.owner = owner;
        this.stsNumber = stsNumber;
        this.year = year;
        this.trailer = trailer;
        this.weight = weight;
        this.power = power;
        this.mileage = mileage;
        this.driver = driver;
        this.loadCapacity = loadCapacity;
    }
}
