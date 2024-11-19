package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.Employee;
import com.example.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
//@Controller
//@ResponseBody
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getMessage() {
        return "Hello World";
    }

    //@PathVariable
    @RequestMapping(value="/login/{fName}/{lName}" , method = RequestMethod.GET)
    public String displayName(@PathVariable String fName, @PathVariable String lName) {
        return fName + " " + lName;
    }

    //@RequestParam
    @RequestMapping(value="param", method = RequestMethod.GET)
    public String welcomeMessage(@RequestParam(value = "name", defaultValue = "Satish") String name) {
        return "Hello "+name;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addEmployee(@RequestBody Employee emp) throws SQLException {
        return employeeService.addEmployee(emp);
    }

    @RequestMapping(value="get", method = RequestMethod.GET)
    public List<Employee> getEmployees() throws SQLException {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value="delete", method = RequestMethod.DELETE)
    public boolean deleteEmployee(@RequestParam int id) throws SQLException {
        return employeeService.deleteEmployee(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public boolean updateEmployee(@RequestBody Employee emp) throws SQLException {
        return employeeService.updateEmployee(emp);
    }

}
