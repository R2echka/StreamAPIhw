package com.example.StreamAPIhw;

import java.util.ArrayList;
import java.util.Arrays;
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
    public void EmployeesByDepartment() {
        Mockito.when(employeeService.getEmployeesByDepartment(-1)).thenReturn(new ArrayList<>());
        assertTrue(departmentService.getEmployeesByDepartment(-1).isEmpty());
    }

    @Test
    public void SalarySum() {
        Mockito.when(employeeService.getEmployeesByDepartment(2)).thenReturn(new ArrayList<>());
        assertEquals(0, departmentService.getSalarySumByDepartment(2));
    }

    @Test
    public void SalaryMinMax() {
        Mockito.when(employeeService.minSalaryEmployee(4)).thenReturn(15);
        assertEquals(15, departmentService.minSalaryEmployee(4));
        Mockito.when(employeeService.maxSalaryEmployee(6)).thenReturn(43);
        assertEquals(43, departmentService.maxSalaryEmployee(6));
    }

    @Test
    public void EmployeesGrouped() {
        final List<Employee> employees = List.of(
            new Employee("name1", (byte) 3, 15),
            new Employee("name2", (byte) 1, 38),
            new Employee("name3", (byte) 1, 342));
        when(employeeService.getAllEmployees()).thenReturn(employees);
        Map<Integer, List<Employee>> expected = new HashMap<>();
        expected.put(1, Arrays.asList(employees.get(1), employees.get(2)));
        expected.put(3, Arrays.asList(employees.get(0)));
        
        assertEquals(expected, departmentService.getAllEmployeesGrouped());
    }
}
