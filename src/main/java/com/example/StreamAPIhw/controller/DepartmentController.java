package com.example.StreamAPIhw.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StreamAPIhw.model.Employee;
import com.example.StreamAPIhw.service.DepartmentService;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable int id){
        return departmentService.getEmployeesByDepartment(id);
    }

    @GetMapping("/{id}/salary/sum")
    public int getSalarySumByDepartment(@PathVariable int id){
        return departmentService.getSalarySumByDepartment(id);
    }

    @GetMapping("/{id}/salary/max")
    public int maxSalaryEmployee(@PathVariable int id){
        return departmentService.maxSalaryEmployee(id);
    }

    @GetMapping("/{id}/salary/min")
    public int minSalaryEmployee(@PathVariable int id){
        return departmentService.minSalaryEmployee(id);
    }

    @GetMapping("/employees")
    public  Map<Integer, List<Employee>> getAllEmployeesGrouped(){
        return departmentService.getAllEmployeesGrouped();
    }
}
