package ru.bogdanov.SpringBootCrudAndJunit.patterns.builder.good;

public class Truck {
    private final String owner;
    private final String stsNumber;
    private final int year;
    private final String trailer;
    private final int weight;
    private final int power;
    private final int mileage;
    private final String driver;
    private final int loadCapacity;

    public Truck(String owner, String stsNumber, int year, String trailer, int weight, int power, int mileage, String driver, int loadCapacity) {
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

    public static TruckBuilder builder() {
        return new TruckBuilder();
    }

    public static class TruckBuilder {
        private String owner;
        private String stsNumber;
        private int year;
        private String trailer;
        private int weight;
        private int power;
        private int mileage;
        private String driver;
        private int loadCapacity;

        public TruckBuilder owner(String owner) {
            this.owner = owner;
            return this;
        }

        public TruckBuilder stsNumber(String stsNumber) {
            this.stsNumber = stsNumber;
            return this;
        }

        public TruckBuilder year(int year) {
            this.year = year;
            return this;
        }

        public TruckBuilder trailer(String trailer) {
            this.trailer = trailer;
            return this;
        }

        public TruckBuilder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public TruckBuilder power(int power) {
            this.power = power;
            return this;
        }

        public TruckBuilder mileage(int owner) {
            this.mileage = mileage;
            return this;
        }

        public TruckBuilder driver(String driver) {
            this.driver = driver;
            return this;
        }

        public TruckBuilder loadCapacity(int loadCapacity) {
            this.loadCapacity = loadCapacity;
            return this;
        }

        public Truck build() {
            return new Truck(owner, stsNumber, year, trailer, weight, power, mileage, driver, loadCapacity);
        }
    }
}
