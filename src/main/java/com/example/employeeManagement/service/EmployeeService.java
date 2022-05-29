package com.example.employeeManagement.service;

import com.example.employeeManagement.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(Long id);

    public Employee createEmployee(Employee employee);

    public Employee updateEmployee(long id, Employee employee);

    public void deleteEmployee(long id);

}
