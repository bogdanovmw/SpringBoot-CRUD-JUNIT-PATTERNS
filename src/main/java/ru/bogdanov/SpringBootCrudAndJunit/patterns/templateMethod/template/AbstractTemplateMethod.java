package ru.bogdanov.SpringBootCrudAndJunit.patterns.templateMethod.template;

import ru.bogdanov.SpringBootCrudAndJunit.patterns.templateMethod.DocumentDao;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.templateMethod.Printer;

import java.io.File;

public abstract class AbstractTemplateMethod {
    private final DocumentDao documentDao;
    private final Printer printer;

    protected AbstractTemplateMethod(DocumentDao documentDao, Printer printer) {
        this.documentDao = documentDao;
        this.printer = printer;
    }

    public final void create() {
        String data = documentDao.getData();
        File document = generate(data);
        printer.print(document);
    }

    protected abstract File generate(String data);
}
