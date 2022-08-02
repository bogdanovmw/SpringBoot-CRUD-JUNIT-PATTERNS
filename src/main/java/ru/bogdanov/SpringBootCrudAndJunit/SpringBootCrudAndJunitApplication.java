package ru.bogdanov.SpringBootCrudAndJunit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootCrudAndJunitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudAndJunitApplication.class, args);
	}

}
