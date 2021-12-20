package nl.saxion.domain;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Student {

    private final static ArrayList<Student> allStudents = new ArrayList<>();

    public static Stream<Student> getAllStudents() {
        return allStudents.stream();
    }

    private final String number;

    private final String name;

    // more info on individual student: date of birth, address, telephone number, etc.
    // these details are not important
    private final String dob;

    public void save() {
        allStudents.add(this);
    }

    public Student(String number, String name) {
        this.number = number;
        this.name = name;
        this.dob = "on some day";
    }


    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
