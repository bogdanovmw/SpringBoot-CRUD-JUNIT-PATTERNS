package ru.bogdanov.SpringBootCrudAndJunit.junit;

import junit.framework.AssertionFailedError;
import junit.framework.TestResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestJunit3 extends TestResult {
    // add the error
    public synchronized void addError(Test test, Throwable t) {
        System.out.println(test);
        System.out.println(t);
    }

    // add the failure
    public synchronized void addFailure(Test test, AssertionFailedError t) {
        System.out.println(test);
        System.out.println(t);
    }

    @Test
    public void testAdd() {
        String s = "null";
        assertNotNull(s);
    }

    // Marks that the test run should stop.
    public synchronized void stop() {
        //stop the test here
    }
}
