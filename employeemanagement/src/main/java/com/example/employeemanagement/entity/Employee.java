package com.example.employeemanagement.entity;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private long emp_id;
    @Column(name = "First_Name")
    private String fName;
    private String lName;
    private String address;
    private int age;

    public Employee(long emp_id, String fName, String lName, String address, int age) {
        this.emp_id = emp_id;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.age = age;
    }

    public Employee() {

    }

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
