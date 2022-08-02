package ru.bogdanov.SpringBootCrudAndJunit.patterns.templateMethod.template.pdf;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class PdfGenerator {
    public File generate(String data) {
        return new File("pdf");
    }
}
