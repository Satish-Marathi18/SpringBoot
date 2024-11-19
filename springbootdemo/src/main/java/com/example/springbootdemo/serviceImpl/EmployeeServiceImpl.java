package com.example.springbootdemo.serviceImpl;

import com.example.springbootdemo.model.Employee;
import com.example.springbootdemo.service.EmployeeService;
import com.example.springbootdemo.util.DBUtil;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {
    private Connection conn = null;
    @Override
    public boolean addEmployee(Employee emp) throws SQLException {
        if(conn == null) {
            conn = DBUtil.getConnection();
        }
        DBUtil.createTable(conn);
            PreparedStatement stmt = conn.prepareStatement("insert into employee values(?,?,?,?,?)");
            stmt.setInt(1, emp.getId());
            stmt.setString(2, emp.getName());
            stmt.setString(4, emp.getAddress());
            stmt.setDouble(3,emp.getSalary());
            stmt.setInt(5,emp.getAge());
            int rowsInserted = stmt.executeUpdate();
            if(rowsInserted > 0) {
                return true;
        }
        return false;
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        if(conn == null) {
            conn = DBUtil.getConnection();
        }
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from employee");
        while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double salary = rs.getDouble("salary");
            String address = rs.getString("address");
            int age = rs.getInt("age");
            employees.add(new Employee(id, name, salary, address, age));
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        if(conn == null) {
            conn = DBUtil.getConnection();
        }
        PreparedStatement stmt = conn.prepareStatement("delete from employee where id=?");
        stmt.setInt(1, id);
        int rowsDeleted = stmt.executeUpdate();
        if(rowsDeleted > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        if(conn == null) {
            conn = DBUtil.getConnection();
        }
        String query = "update employee set name=?,salary=?,address=?,age=? where id=?";
        try(PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1,employee.getName());
            stmt.setDouble(2,employee.getSalary());
            stmt.setString(3,employee.getAddress());
            stmt.setInt(4,employee.getAge());
            stmt.setInt(5,employee.getId());
            if(stmt.executeUpdate() > 0) {
                return true;
            }
        }
        return false;
    }


}
