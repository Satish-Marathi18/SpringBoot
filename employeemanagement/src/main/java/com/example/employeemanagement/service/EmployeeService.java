package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    List<Employee> getEmployeeByFName(String firstName);

    Employee updateEmployee(long id, Employee employee);

    void deleteEmployee(long id);
}
