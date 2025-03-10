package com.example.StreamAPIhw.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StreamAPIhw.model.Employee;

@Service
public class DepartmentService {

    @Autowired
    private EmployeeService employeeService;

    public List<Employee> getEmployeesByDepartment(int department) {
        return this.employeeService.getEmployeesByDepartment(department);
    }

    public int getSalarySumByDepartment(int department) {
        return this.employeeService.getEmployeesByDepartment(department).stream()
        .mapToInt(Employee::getSalary)
        .sum();
    }
    
    public int maxSalaryEmployee(int department) {
        return this.employeeService.getEmployeesByDepartment(department).stream()
                .mapToInt(Employee::getSalary)
                .max()
                .orElseThrow();
    }

    public int minSalaryEmployee(int department) {
        return this.getEmployeesByDepartment(department).stream()
        .mapToInt(Employee::getSalary)
        .min()
        .orElseThrow();
    }

    public Map<Integer, List<Employee>> getAllEmployeesGrouped() {
        return this.employeeService.getAllEmployees().stream()
        .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
