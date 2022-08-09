package ru.bogdanov.SpringBootCrudAndJunit.junit;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class TestJunit2 extends TestCase {
    protected double fValue1;
    protected double fValue2;

    @Override
    protected void setUp() throws Exception {
        fValue1 = 2.0;
        fValue2 = 3.0;
        System.out.println(fValue1 + ", " + fValue2);
    }

    @Test
    public void testAdd2() {
        System.out.println(this.countTestCases());

        String name = this.getName();
        System.out.println(name);

        this.setName("testNewAdd");
        String newName = this.getName();
        System.out.println(newName);
    }

    @Override
    protected void tearDown() throws Exception {
        fValue1 = 0;
        fValue2 = 0;
        System.out.println(fValue1 + ", " + fValue2);
    }
}
