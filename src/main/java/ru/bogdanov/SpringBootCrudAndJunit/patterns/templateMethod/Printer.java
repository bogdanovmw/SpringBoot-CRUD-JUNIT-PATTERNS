package ru.bogdanov.SpringBootCrudAndJunit.patterns.templateMethod;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class Printer {
    public void print(File file) {
        System.out.println("Print file: " + file.getName());
    }
}
