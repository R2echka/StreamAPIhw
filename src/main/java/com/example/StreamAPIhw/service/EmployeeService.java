package com.example.StreamAPIhw.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.StreamAPIhw.model.Employee;

@Service
public class EmployeeService {

    final List<Employee> employees = List.of(
            new Employee("name1", (byte) 1, 12300),
            new Employee("name2", (byte) 2, 38240),
            new Employee("name3", (byte) 3, 43280),
            new Employee("name4", (byte) 4, 83220),
            new Employee("name5", (byte) 5, 34730),
            new Employee("name6", (byte) 3, 43300),
            new Employee("name7", (byte) 1, 34870),
            new Employee("name8", (byte) 4, 32840),
            new Employee("name9", (byte) 5, 23820),
            new Employee("name10", (byte) 2, 28900));

    public List<Employee> getEmployeesByDepartment(int department) {
        return employees.stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    ;

    public List<Employee> getAllEmployees() {
        return employees.stream()
                .collect(Collectors.toList());
    }

    ;

    public int minSalaryEmployee(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .min()
                .orElseThrow();
    }

    ;

    public int maxSalaryEmployee(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .max()
                .orElseThrow();
    }
}
