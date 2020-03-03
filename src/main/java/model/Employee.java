package model;

import java.math.BigDecimal;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private String department;
    private BigDecimal salary;

    public Employee(String firstName, String lastName, int age,
                    Gender gender, String department, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
    }

    public Employee( String uplastName, int upAge, String upDepartment, BigDecimal upSalary) {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-20s | %-20s | %-5s | %-10s | %-20s | %-20s",
                getId(),
                getFirstName(),
                getLastName(),
                getAge(),
                getGender(),
                getDepartment(),
                getSalary());
    }

    }


