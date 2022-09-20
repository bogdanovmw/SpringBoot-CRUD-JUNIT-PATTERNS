package ru.bogdanov.SpringBootCrudAndJunit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan("ru.bogdanov.SpringBootCrudAndJunit")
public class SpringBootCrudAndJunitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudAndJunitApplication.class, args);
	}

}
