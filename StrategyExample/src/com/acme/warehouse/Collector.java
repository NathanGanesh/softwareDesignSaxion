package com.acme.warehouse;

public class Collector extends Employee {
    private int hoursWorked = 150;
    private double hourlySalary = 5_00;

    public Collector(String name, String phoneNumber, String emailAddress) {
        super(name, phoneNumber, emailAddress);
    }



    public double getHourlySalary() {
        return hourlySalary;
    }



    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlySalary * hoursWorked;
    }
}
