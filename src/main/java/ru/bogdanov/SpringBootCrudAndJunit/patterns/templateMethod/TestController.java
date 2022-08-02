package ru.bogdanov.SpringBootCrudAndJunit.patterns.templateMethod;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.templateMethod.template.AbstractTemplateMethod;

@RestController
public class TestController {
    private final AbstractTemplateMethod abstractTemplateMethod;

    // @Qualifier("excelDocument")
    public TestController(@Qualifier("excelDocument") AbstractTemplateMethod abstractTemplateMethod) {
        this.abstractTemplateMethod = abstractTemplateMethod;
    }

    @GetMapping
    public void create() {
        abstractTemplateMethod.create();
    }
}
