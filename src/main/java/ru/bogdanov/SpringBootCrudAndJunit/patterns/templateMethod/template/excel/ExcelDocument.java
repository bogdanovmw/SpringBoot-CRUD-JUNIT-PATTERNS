package ru.bogdanov.SpringBootCrudAndJunit.patterns.templateMethod.template.excel;

import org.springframework.stereotype.Component;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.templateMethod.template.AbstractTemplateMethod;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.templateMethod.DocumentDao;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.templateMethod.Printer;

import java.io.File;

@Component
public class ExcelDocument extends AbstractTemplateMethod {
    private final ExcelGenerator excelGenerator;

    protected ExcelDocument(DocumentDao documentDao, Printer printer, ExcelGenerator excelGenerator) {
        super(documentDao, printer);
        this.excelGenerator = excelGenerator;
    }

    @Override
    public File generate(String data) {
        return excelGenerator.generate(data);
    }
}
