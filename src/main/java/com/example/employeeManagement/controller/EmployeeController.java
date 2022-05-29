package com.example.employeeManagement.controller;

import com.example.employeeManagement.model.Employee;
import com.example.employeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/employee/{id}")
    public  Employee updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
        Map<String, Boolean> map = new HashMap<>();
        map.put("deleted", true);
        return ResponseEntity.ok(map);
    }
}
