package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    public boolean addEmployee(Employee employee) throws SQLException;

    public List<Employee> getAllEmployees() throws SQLException;

    public boolean deleteEmployee(int id) throws SQLException;

    public boolean updateEmployee(Employee employee) throws SQLException;

}
