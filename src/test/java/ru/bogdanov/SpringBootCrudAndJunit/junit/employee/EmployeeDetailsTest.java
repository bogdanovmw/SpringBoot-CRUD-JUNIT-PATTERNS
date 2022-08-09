package ru.bogdanov.SpringBootCrudAndJunit.junit.employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeDetailsTest {
    EmpBusinessLogic logic = new EmpBusinessLogic();
    EmployeeDetails employee = new EmployeeDetails();

    @Test
    void testCalculateAppriasal() {
        employee.setName("Rajeev");
        employee.setAge(25);
        employee.setMonthlySalary(8000);

        double res = logic.calculateAppraisal(employee);
        assertEquals(500, res, 0.0);
    }

    @Test
    public void testCalculateYearlySalary() {
        employee.setName("Rajeev");
        employee.setAge(25);
        employee.setMonthlySalary(8000);

        double salary = logic.calculateYearlySalary(employee);
        assertEquals(96000, salary, 0.0);
    }
}
