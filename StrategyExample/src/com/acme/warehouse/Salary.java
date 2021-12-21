package com.acme.warehouse;

public interface Salary {
    public double calculateSalary();
}

//http://www.newthinktank.com/2012/08/strategy-design-pattern-tutorial/
//class ForkliftDriverSalary implements Salary {
//    @Override
//    public double calculateSalary(Employee employee) {
//        return 0;
//    }
//}
//
//class CollectorSalary implements Salary {
//
//    @Override
//    public double calculateSalary(Employee employee) {
//        return 0;
//    }
//}