package com.acme.warehouse;

public class ForkliftDriver extends Employee implements Salary {
    private double monthlySalary = 2_000.00;

    public ForkliftDriver(String name, String phoneNumber, String emailAddress) {
        super(name, phoneNumber, emailAddress);
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}
