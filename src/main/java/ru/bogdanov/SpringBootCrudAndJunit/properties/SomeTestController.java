package ru.bogdanov.SpringBootCrudAndJunit.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/some")
public class SomeTestController {
    @Autowired
    private SomeTestProperties someTestProperties;

    @GetMapping
    public void test() {
        System.out.println(someTestProperties.getNumberValue());
        System.out.println(someTestProperties.getTextValue());
        someTestProperties.getList().forEach(System.out::println);
    }
}
