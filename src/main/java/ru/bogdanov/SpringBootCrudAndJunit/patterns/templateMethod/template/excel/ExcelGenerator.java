package ru.bogdanov.SpringBootCrudAndJunit.patterns.templateMethod.template.excel;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ExcelGenerator {
    public File generate(String data) {
        return new File("excel");
    }
}
