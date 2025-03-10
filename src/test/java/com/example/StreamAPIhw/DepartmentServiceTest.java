package com.example.StreamAPIhw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.StreamAPIhw.model.Employee;
import com.example.StreamAPIhw.service.DepartmentService;
import com.example.StreamAPIhw.service.EmployeeService;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;

    @Test
    public void employeesByDepartment() {
        final List<Employee> employees = List.of(
            new Employee("name1", (byte) 3, 93200),
            new Employee("name2", (byte) 3, 10),
            new Employee("name3", 4, 1));
        Mockito.when(employeeService.getEmployeesByDepartment(-1)).thenReturn(new ArrayList<>());
        Mockito.when(employeeService.getEmployeesByDepartment(3)).thenReturn(List.of(employees.get(0), employees.get(1)));
        assertTrue(departmentService.getEmployeesByDepartment(-1).isEmpty());
        assertEquals(List.of(employees.get(0), employees.get(1)), departmentService.getEmployeesByDepartment(3));
    }

    @Test
    public void salarySum() {
        final List<Employee> employees = List.of(
            new Employee("name1", (byte) 5, 15),
            new Employee("name2", (byte) 2, 4380));
        Mockito.when(employeeService.getEmployeesByDepartment(2)).thenReturn(List.of(employees.get(1)));
        Mockito.when(employeeService.getEmployeesByDepartment(5)).thenReturn(List.of(employees.get(0)));
        assertEquals(4380, departmentService.getSalarySumByDepartment(2));
        assertEquals(15, departmentService.getSalarySumByDepartment(5));
    }

    @Test
    public void salaryMinMax() {
        final List<Employee> employees = List.of(
            new Employee("name1", (byte) 5, 15),
            new Employee("name2", (byte) 6, 43));
        Mockito.when(employeeService.getEmployeesByDepartment(4)).thenReturn(List.of(employees.get(0)));
        assertEquals(15, departmentService.minSalaryEmployee(4));
        Mockito.when(employeeService.getEmployeesByDepartment(6)).thenReturn(List.of(employees.get(1)));
        assertEquals(43, departmentService.maxSalaryEmployee(6));
    }

    @Test
    public void employeesGrouped() {
        final List<Employee> employees = List.of(
            new Employee("name1", (byte) 3, 15),
            new Employee("name2", (byte) 1, 38),
            new Employee("name3", (byte) 1, 342));
        when(employeeService.getAllEmployees()).thenReturn(employees);
        Map<Integer, List<Employee>> expected = new HashMap<>();
        expected.put(1, List.of(employees.get(1), employees.get(2)));
        expected.put(3, List.of(employees.get(0)));
        
        assertEquals(expected, departmentService.getAllEmployeesGrouped());
    }
}
