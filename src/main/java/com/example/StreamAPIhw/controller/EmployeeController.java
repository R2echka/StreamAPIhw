package com.example.StreamAPIhw.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.StreamAPIhw.model.Employee;
import com.example.StreamAPIhw.service.EmployeeService;

@RestController
@RequestMapping("/departments")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/min-salary")
    public int minSalaryEmployee(@RequestParam(value = "departmentId", required = false) Integer departmentId) {
        return employeeService.minSalaryEmployee(departmentId);
    }

    @GetMapping(path = "/max-salary")
    public int maxSalaryEmployee(@RequestParam(value = "departmentId", required = false) Integer departmentId) {
        return employeeService.maxSalaryEmployee(departmentId);
    }

    @GetMapping(path = "/all")
    public List<Employee> getAllEmployees(@RequestParam(value = "departmentId", required = false) Integer departmentId) {
        if (departmentId != null) {
            return employeeService.getEmployeesByDepartment(departmentId);
        } else {
            return employeeService.getAllEmployees();
        }
    }
}
