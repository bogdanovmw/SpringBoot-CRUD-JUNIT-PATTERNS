package ru.bogdanov.SpringBootCrudAndJunit.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "some.test")
@Component
@Getter
@Setter
public class SomeTestProperties {
    private Integer numberValue;
    private String textValue;
    private final List<String> list = new ArrayList<>();
}
