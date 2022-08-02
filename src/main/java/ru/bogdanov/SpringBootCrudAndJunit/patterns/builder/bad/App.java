package ru.bogdanov.SpringBootCrudAndJunit.patterns.builder.bad;

public class App {
    public Track testOne() {
        return new Track("owner", "stsNumber", 2022, "trailer", 400, 1000, 0);
    }

    public Track testTwo() {
        return new Track("owner", "stsNumber", 2022, "trailer", 400, 1000, 0, "Ivanov");
    }

    public Track testTree() {
        return new Track("owner", "stsNumber", 2022, "trailer", 400, 1000, 0, "Ivanov", 20000);
    }
}
