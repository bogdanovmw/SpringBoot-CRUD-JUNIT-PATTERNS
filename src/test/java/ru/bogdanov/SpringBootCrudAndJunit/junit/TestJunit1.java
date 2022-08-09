package ru.bogdanov.SpringBootCrudAndJunit.junit;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestJunit1 {
    @Test
//    @Test(timeout = 1000)
//    @Test(expected = ArithmeticException.class)
    void testAdd() {
        int num = 5;
        String temp = null;
        String str = "Junit is working fine";

        assertEquals("Junit is working fine", str);
        assertFalse(num > 6);
        assertNotNull(temp);
    }
}
