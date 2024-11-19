package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        Employee emp = getEmployeeById(id);
        emp.setAddress(employee.getAddress());
        emp.setfName(employee.getfName());
        emp.setlName(employee.getlName());
        emp.setAge(employee.getAge());
        return employeeRepository.save(emp);
    }

    @Override
    public void deleteEmployee(long id) {
        Employee emp = getEmployeeById(id);
        employeeRepository.deleteById(id);
    }
}

