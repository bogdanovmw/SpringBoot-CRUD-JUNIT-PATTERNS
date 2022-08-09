package ru.bogdanov.SpringBootCrudAndJunit.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageUtilTest {
    String message = "Hello World!";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    void printMessageTest() {
        assertEquals(message, messageUtil.printMessage());
    }
}
