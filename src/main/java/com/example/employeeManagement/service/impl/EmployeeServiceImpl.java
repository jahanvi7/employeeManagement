package com.example.employeeManagement.service.impl;

import com.example.employeeManagement.exception.EmployeeNotFoundException;
import com.example.employeeManagement.model.Employee;
import com.example.employeeManagement.repository.EmployeeRepository;
import com.example.employeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Employee does not exist with id : "+id));

        return employee;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(long id, Employee newEmployee) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee does not exist with id: "+id));
        employee.setFirstName(newEmployee.getFirstName());
        employee.setLastName(newEmployee.getLastName());
        employee.setEmail(newEmployee.getEmail());
        return employee;
    }

    @Override
    public void deleteEmployee(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee does not exist with id: "+id));
        employeeRepository.delete(employee);
    }
}
