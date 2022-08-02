package ru.bogdanov.SpringBootCrudAndJunit.testing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.bogdanov.SpringBootCrudAndJunit.testing.exceptions.UserNotFoundException;

@ControllerAdvice
public class UserNotFoundController {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFound(UserNotFoundException ex) {
        return ex.getMessage();
    }
}
