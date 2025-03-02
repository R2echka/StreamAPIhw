package com.example.StreamAPIhw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.StreamAPIhw.service.EmployeeService;

public class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeService();

    @Test
    public void EmployeesByDepartment() {
        assertEquals(2, employeeService.getEmployeesByDepartment(1).size());
        assertTrue(employeeService.getEmployeesByDepartment(-1).isEmpty());
    }

    @Test
    public void AllEmployees() {
        assertEquals(10, employeeService.getAllEmployees().size());
    }

    @Test
    public void minMaxSalary() {
        assertEquals(12300, employeeService.minSalaryEmployee(1));
        assertEquals(43300, employeeService.maxSalaryEmployee(3));
    }
}
