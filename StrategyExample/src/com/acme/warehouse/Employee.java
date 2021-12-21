package com.acme.warehouse;

abstract public class Employee{
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private Salary salary;
    protected Employee(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public double calculateSalary(){
        return salary.calculateSalary();
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }


}
