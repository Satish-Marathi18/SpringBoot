package com.example.springbootdemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/employees";
        String user = "root";
        String password = "Satish@123";
        return DriverManager.getConnection(url, user, password);
    }

    public static void createTable(Connection conn) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS employee("+"id int primary key,"
                +"name varchar(20) not null,"
                +"salary int not null,"
                +"address varchar(30) not null,"
                +"age int not null)";

        try(Statement stmt = conn.createStatement()){
            stmt.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
