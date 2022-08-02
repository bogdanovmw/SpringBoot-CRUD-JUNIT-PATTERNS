package ru.bogdanov.SpringBootCrudAndJunit.patterns.templateMethod.template.pdf;

import org.springframework.stereotype.Component;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.templateMethod.template.AbstractTemplateMethod;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.templateMethod.DocumentDao;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.templateMethod.Printer;

import java.io.File;

@Component
public class PdfDocument extends AbstractTemplateMethod {
    private final PdfGenerator pdfGenerator;

    protected PdfDocument(DocumentDao documentDao, Printer printer, PdfGenerator pdfGenerator) {
        super(documentDao, printer);
        this.pdfGenerator = pdfGenerator;
    }

    @Override
    public File generate(String data) {
        return pdfGenerator.generate(data);
    }
}
